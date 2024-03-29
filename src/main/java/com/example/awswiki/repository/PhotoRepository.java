package com.example.awswiki.repository;

import com.example.awswiki.domain.photo.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface PhotoRepository extends MongoRepository<Photo, String> {
    List<Photo> findAll();
}
