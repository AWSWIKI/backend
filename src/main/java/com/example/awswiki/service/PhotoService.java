package com.example.awswiki.service;

import com.example.awswiki.config.S3.S3Service;
import com.example.awswiki.config.S3.dto.S3Result;
import com.example.awswiki.domain.photo.Photo;
import com.example.awswiki.repository.PhotoRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final S3Service s3Service;

    public List<Photo> findAll() {
        List<Photo> all = photoRepository.findAll();
        all.sort((j1, j2) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDate date1 = LocalDate.parse(j1.getDate(), formatter);
            LocalDate date2 = LocalDate.parse(j2.getDate(), formatter);
            return date2.compareTo(date1); // 내림차순 정렬
        });
        return all;
    }

    public Integer savePhoto(List<MultipartFile> multipartFile) {
        int count = (int) photoRepository.count();
        List<S3Result> s3Results = s3Service.uploadFile(multipartFile);
        Photo photo = new Photo(count, s3Results.get(0).getImgUrl());
        Photo save = photoRepository.save(photo);
        return save.getIndex();
    }

    public Photo findByIndex(int id) {
        return photoRepository.findByIndex(id);
    }

    public List<Photo> findByDate(String date) {
        List<Photo> photos=photoRepository.findAll();
        List<Photo> result = new ArrayList<>();
        for (int i = 0; i < photos.size(); i++) {
            if (photos.get(i).getDate().contains(date)) {
                result.add(photos.get(i));
            }
        }
        return result;
    }
}
