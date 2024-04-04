package com.example.awswiki.controller;

import com.example.awswiki.domain.note.Note;
import com.example.awswiki.domain.note.dto.NoteRequestDto.NoteReqInfo;
import com.example.awswiki.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @GetMapping("/note")
    public List<Note> getAllNote() {
        logger.info("Responding with body: {}", "필기 정보 출력");
        return noteService.findAll();
    }

    @GetMapping("/note/{id}")
    public Note getNote(@PathVariable int id) {
        logger.info("Responding with body: {}", "특정 필기 정보 출력");
        return noteService.findByIndex(id);
    }

    /**
     * Note 저장
     */
    @PostMapping("note")
    public ResponseEntity<Integer> insertNote(@RequestPart(value = "images", required = false) List<MultipartFile> multipartFile,
                                              @RequestPart(value = "NoteReqInfo") NoteReqInfo noteReqInfo) throws IOException {
        logger.info("Responding with body: {}", "필기 정보 저장");
        return ResponseEntity.ok(noteService.saveNote(multipartFile, noteReqInfo));
    }

}
