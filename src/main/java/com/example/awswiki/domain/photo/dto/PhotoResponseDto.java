package com.example.awswiki.domain.photo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PhotoResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhotoReqInfo {
        private String id;
        private int index;
        private String date;
        private String 이미지;
    }
}
