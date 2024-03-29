package com.example.awswiki.controller;

import com.example.awswiki.domain.note.Note;
import com.example.awswiki.domain.note.dto.NoteRequestDto.NoteReqInfo;
import com.example.awswiki.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/note")
    public List<Note> getAllNote() {
        return noteService.findAll();
    }

    /**
     * Note 저장
     */
    @PostMapping("note")
    public ResponseEntity<Integer> insertNote(@RequestPart(value = "images", required = false) List<MultipartFile> multipartFile,
                                              @RequestPart(value = "NoteReqInfo") NoteReqInfo noteReqInfo) throws IOException {
        return ResponseEntity.ok(noteService.saveNote(multipartFile, noteReqInfo));
    }

}