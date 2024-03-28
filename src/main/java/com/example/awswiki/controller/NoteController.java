package com.example.awswiki.controller;

import com.example.awswiki.domain.Note;
import com.example.awswiki.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/note")
    public List<Note> getAllNote() {
        return noteService.findAll();
    }
}
