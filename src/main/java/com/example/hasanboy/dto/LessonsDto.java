package com.example.hasanboy.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonsDto {
    private Integer id;
    private Integer courseId;
    private String title;
    private String description;
    private String content;
    private boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;

}
