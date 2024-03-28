package com.example.awswiki.repository;


import com.example.awswiki.domain.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface JobRepository extends MongoRepository<Job, String> {
}
