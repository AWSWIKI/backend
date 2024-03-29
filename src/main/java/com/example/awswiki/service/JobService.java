package com.example.awswiki.service;

import com.example.awswiki.config.S3.S3Service;
import com.example.awswiki.config.S3.dto.S3Result;
import com.example.awswiki.domain.job.Job;
import com.example.awswiki.domain.job.dto.JobRequestDto;
import com.example.awswiki.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JobService {

    private final JobRepository jobRepository;
    private final S3Service s3Service;
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Integer saveJob(List<MultipartFile> multipartFile, JobRequestDto.JobReqInfo jobReqInfo) {
        int count = (int) jobRepository.count();
        List<S3Result> s3Results = s3Service.uploadFile(multipartFile);
        Job job = new Job(jobReqInfo, count, s3Results.get(0).getImgUrl());
        Job save = jobRepository.save(job);
        return save.getIndex();
    }

    public Job findById(int id) {
        return jobRepository.findById(id);
    }
}
