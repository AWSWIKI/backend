package com.example.awswiki.domain.photo;

import com.example.awswiki.domain.note.dto.NoteRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "photo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Photo {
    @Id
    private String id;
    private int index;
    private String date;
    private String 이미지;
    public Photo(int count, String imageUrl){
        this.index = count+1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.date = LocalDateTime.now().format(formatter);
        this.이미지 = imageUrl;
    }
}
