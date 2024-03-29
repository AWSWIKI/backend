package com.example.awswiki.repository;


import com.example.awswiki.domain.job.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface JobRepository extends MongoRepository<Job, String> {
    List<Job> findAll();

    Job findById(int id);
}
