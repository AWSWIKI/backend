package com.example.awswiki.domain.photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
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
    @CreatedDate
    private String 날짜;
    private String 이미지;
}
