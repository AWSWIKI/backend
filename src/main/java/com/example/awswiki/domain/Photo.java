package com.example.awswiki.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Photo {
    @Id
    private String id;
    private int index;
    private String 이미지;
}
