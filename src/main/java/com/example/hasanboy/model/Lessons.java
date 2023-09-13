package com.example.hasanboy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="lesssons2")
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
