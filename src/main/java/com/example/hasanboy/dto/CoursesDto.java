package com.example.hasanboy.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDto {
    private Integer id;
    private String type;
    private String name;
    private String description;
    private Integer perWeek;
    private Integer durationMonth;
    private Integer durationDays;
    private Integer durationHours;

    private List<LessonsDto> lessonsList;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
