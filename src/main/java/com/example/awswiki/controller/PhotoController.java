package com.example.awswiki.controller;

import com.example.awswiki.domain.note.Note;
import com.example.awswiki.domain.note.dto.NoteRequestDto;
import com.example.awswiki.domain.photo.Photo;
import com.example.awswiki.service.PhotoService;
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
public class PhotoController {
    private final PhotoService photoService;
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @GetMapping("/photo")
    public List<Photo> getAllPhoto() {
        logger.info("Responding with body: {}", "강사님 필기 정보 출력");
        return photoService.findAll();
    }

    @GetMapping("/photo/{id}")
    public Photo getPhoto(@PathVariable int id) {
        logger.info("Responding with body: {}", "강사님 특정 필기 정보 출력");
        return photoService.findByIndex(id);
    }

    @GetMapping("/photo/date/{date}")
    public List<Photo> getPhotoByDate(@PathVariable String date) {
        logger.info("Responding with body: {}", "강사님 필기 특정 날짜 출력");
        return photoService.findByDate(date);
    }

    /**
     * Photo 저장
     */
    @PostMapping("photo")
    public ResponseEntity<Integer> insertPhoto(@RequestPart(value = "images", required = false) List<MultipartFile> multipartFile) throws IOException {
        logger.info("Responding with body: {}", "강사님 필기 저장");
        return ResponseEntity.ok(photoService.savePhoto(multipartFile));
    }
}
