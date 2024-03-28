package com.example.awswiki.repository;

import com.example.awswiki.domain.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findAll();
}
