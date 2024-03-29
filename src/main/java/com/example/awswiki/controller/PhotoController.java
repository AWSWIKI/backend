package com.example.awswiki.controller;

import com.example.awswiki.domain.note.Note;
import com.example.awswiki.domain.note.dto.NoteRequestDto;
import com.example.awswiki.domain.photo.Photo;
import com.example.awswiki.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PhotoController {
    private final PhotoService photoService;
    @GetMapping("/photo")
    public List<Photo> getAllPhoto() {
        return photoService.findAll();
    }

    @GetMapping("/photo/{id}")
    public Photo getPhoto(@PathVariable int id) {
        return photoService.findById(id);
    }

    @GetMapping("/photo/{date}")
    public List<Photo> getPhotoByDate(@PathVariable String date) {
        return photoService.findByDate(date);
    }

    /**
     * Photo 저장
     */
    @PostMapping("photo")
    public ResponseEntity<Integer> insertPhoto(@RequestPart(value = "images", required = false) List<MultipartFile> multipartFile) throws IOException {
        return ResponseEntity.ok(photoService.savePhoto(multipartFile));
    }
}
