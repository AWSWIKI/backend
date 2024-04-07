package com.example.awswiki.service;

import com.example.awswiki.config.S3.S3Service;
import com.example.awswiki.config.S3.dto.S3Result;
import com.example.awswiki.domain.note.Note;
import com.example.awswiki.domain.note.dto.NoteRequestDto.NoteReqInfo;
import com.example.awswiki.repository.NoteRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final S3Service s3Service;

    public Integer saveNote(List<MultipartFile> multipartFile, NoteReqInfo noteReqInfo) {
        int count = (int) noteRepository.count();
        List<S3Result> s3Results = s3Service.uploadFile(multipartFile);
        Note note = new Note(noteReqInfo, count, s3Results.get(0).getImgUrl());
        Note save = noteRepository.save(note);
        return save.getIndex();
    }

    public List<Note> findAll() {
        List<Note> all = noteRepository.findAll();
        all.sort((j1, j2) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDate date1 = LocalDate.parse(j1.get날짜(), formatter);
            LocalDate date2 = LocalDate.parse(j2.get날짜(), formatter);
            return date2.compareTo(date1); // 내림차순 정렬
        });
        return all;
    }

    public Note findByIndex(int id) {
        return noteRepository.findByIndex(id);
    }
}
