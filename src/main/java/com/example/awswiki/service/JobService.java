package com.example.awswiki.service;

import com.example.awswiki.config.S3.S3Service;
import com.example.awswiki.config.S3.dto.S3Result;
import com.example.awswiki.domain.job.Job;
import com.example.awswiki.domain.job.dto.JobRequestDto;
import com.example.awswiki.repository.JobRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class JobService {

    private final JobRepository jobRepository;
    private final S3Service s3Service;

    public List<Job> findAll() {
        List<Job> all = jobRepository.findAll();
        all.sort((j1, j2) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDate date1 = LocalDate.parse(j1.get날짜(), formatter);
            LocalDate date2 = LocalDate.parse(j2.get날짜(), formatter);
            return date2.compareTo(date1); // 내림차순 정렬
        });
        return all;
    }

    public Integer saveJob(List<MultipartFile> multipartFile, JobRequestDto.JobReqInfo jobReqInfo) {
        int count = (int) jobRepository.count();
        List<S3Result> s3Results = s3Service.uploadFile(multipartFile);
        Job job = new Job(jobReqInfo, count, s3Results.get(0).getImgUrl());
        Job save = jobRepository.save(job);
        return save.getIndex();
    }

    public Job findByIndex(int id) {
        return jobRepository.findByIndex(id);
    }
}
