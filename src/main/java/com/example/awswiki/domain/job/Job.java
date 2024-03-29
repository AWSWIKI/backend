package com.example.awswiki.domain.job;

import com.example.awswiki.domain.job.dto.JobRequestDto.JobReqInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public Job(JobReqInfo jobReqInfo, int count, String imageUrl){
        this.index = count+1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.날짜 = LocalDateTime.now().format(formatter);
        this.제목 = jobReqInfo.get제목();
        this.작성자 = jobReqInfo.get작성자();
        this.내용 = jobReqInfo.get내용();
        this.이미지 = imageUrl;
    }
}
