package com.example.sujanproject.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class NovelPojo {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String summary;
    private MultipartFile novelThumbnail;
    private Long userId; // The ID of the user who wrote the novel


//    private List<ChapterPojo> chapters;

}
