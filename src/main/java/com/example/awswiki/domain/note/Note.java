package com.example.awswiki.domain.note;

import com.example.awswiki.domain.note.dto.NoteRequestDto.NoteReqInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "note")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Note {
    @Id
    private String id;
    private int index;
    private String 날짜;
    private String 제목;
    private String 작성자;
    private String 내용;
    private String 이미지;

    public Note(NoteReqInfo noteReqInfo, int count, String imageUrl){
        this.index = count+1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.날짜 = LocalDateTime.now().format(formatter);
        this.제목 = noteReqInfo.get제목();
        this.작성자 = noteReqInfo.get작성자();
        this.내용 = noteReqInfo.get내용();
        this.이미지 = imageUrl;
    }
}
