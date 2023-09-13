package com.example.hasanboy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cours1")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String name;
    private String description;
    private Integer perWeek;
    private Integer durationMonth;
    private Integer durationDays;
    private Integer durationHours;
    @OneToMany(mappedBy = "courseId",fetch = FetchType.EAGER)
    private List<Lessons> lessonsList;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
