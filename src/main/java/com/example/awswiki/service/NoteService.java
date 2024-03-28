package com.example.awswiki.service;

import com.example.awswiki.domain.Note;
import com.example.awswiki.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public Note saveNote(Note note) {
        return noteRepository.insert(note);
    }

    public List<Note> findAll( ) {
        return noteRepository.findAll();
    }
}
