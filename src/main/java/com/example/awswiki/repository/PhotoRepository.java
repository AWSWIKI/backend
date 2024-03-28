package com.example.awswiki.repository;

import com.example.awswiki.domain.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
