package com.example.awswiki.domain.note.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NoteResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NoteResInfo {
        private String id;
        private int index;
        private String 날짜;
        private String 제목;
        private String 작성자;
        private String 내용;
        private String 이미지;
    }
}
