package com.example.awswiki.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Job {
    @Id
    private String id;
    private int index;
    private String 날짜;
    private String 제목;
    private String 작성자;
    private String 내용;
    private String 이미지;
}
