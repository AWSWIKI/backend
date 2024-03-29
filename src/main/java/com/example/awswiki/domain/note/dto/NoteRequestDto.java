package com.example.awswiki.domain.note.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NoteRequestDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NoteReqInfo {
        private String 제목;
        private String 작성자;
        private String 내용;
    }

}
