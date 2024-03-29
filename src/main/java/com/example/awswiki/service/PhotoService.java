package com.example.awswiki.service;

import com.example.awswiki.config.S3.S3Service;
import com.example.awswiki.config.S3.dto.S3Result;
import com.example.awswiki.domain.photo.Photo;
import com.example.awswiki.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final S3Service s3Service;

    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    public Integer savePhoto(List<MultipartFile> multipartFile) {
        int count = (int) photoRepository.count();
        List<S3Result> s3Results = s3Service.uploadFile(multipartFile);
        Photo photo = new Photo(count, s3Results.get(0).getImgUrl());
        Photo save = photoRepository.save(photo);
        return save.getIndex();
    }

    public Photo findById(int id) {
        return photoRepository.findById(id);
    }

    public List<Photo> findByDate(String date) {
        return photoRepository.findByDate(date);
    }
}
