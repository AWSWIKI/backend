package com.example.awswiki.domain.job.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class JobRequestDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JobReqInfo {
        private String 제목;
        private String 작성자;
        private String 내용;
    }
}
