package com.example.awswiki.controller;

import com.example.awswiki.domain.job.Job;
import com.example.awswiki.domain.job.dto.JobRequestDto;
import com.example.awswiki.service.JobService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class JobController {
    private final JobService jobService;
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    /**
     * 모든 거 출력
     */
    @GetMapping("/job")
    public ResponseEntity<List<Job>> getAllJob() {
        logger.info("Responding with body: {}", "모든 직업/취업 정보 출력");
        return ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/job/{id}")
    public Job getJob(@PathVariable int id) {
        logger.info("Responding with body: {}", "특정 직업/취업 정보 출력");
        return jobService.findByIndex(id);
    }

    /**
     * Job 저장
     */
    @PostMapping("job")
    public ResponseEntity<Integer> insertJob(@RequestPart(value = "images", required = false) List<MultipartFile> multipartFile,
                                              @RequestPart(value = "JobReqInfo") JobRequestDto.JobReqInfo jobReqInfo) throws IOException {
        logger.info("Responding with body: {}", "직업/취업 정보 저장");
        return ResponseEntity.ok(jobService.saveJob(multipartFile, jobReqInfo));
    }
}
