package com.example.awswiki.domain.job.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class JobResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JobResInfo {
        private String id;
        private int index;
        private String 날짜;
        private String 제목;
        private String 작성자;
        private String 내용;
        private String 이미지;
    }
}
