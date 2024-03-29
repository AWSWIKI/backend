package com.example.awswiki.repository;

import com.example.awswiki.domain.note.Note;
import com.example.awswiki.domain.note.dto.NoteResponseDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findAll();
    Note findByIndex(int id);
}
