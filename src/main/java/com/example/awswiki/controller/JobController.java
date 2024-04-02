package com.example.awswiki.controller;

import com.example.awswiki.domain.job.Job;
import com.example.awswiki.domain.job.dto.JobRequestDto;
import com.example.awswiki.service.JobService;
import lombok.RequiredArgsConstructor;
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

    /**
     * 모든 거 출력
     */
    @GetMapping("/job")
    public List<Job> getAllJob() {
        return jobService.findAll();
    }

    @GetMapping("/job/{id}")
    public Job getJob(@PathVariable int id) {
        return jobService.findByIndex(id);
    }

    /**
     * Job 저장
     */
    @PostMapping("job")
    public ResponseEntity<Integer> insertJob(@RequestPart(value = "images", required = false) List<MultipartFile> multipartFile,
                                              @RequestPart(value = "JobReqInfo") JobRequestDto.JobReqInfo jobReqInfo) throws IOException {
        return ResponseEntity.ok(jobService.saveJob(multipartFile, jobReqInfo));
    }
}
