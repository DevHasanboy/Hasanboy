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
@Table(name = "authority")
public class Authorities {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorityId;
    private String  username;
    private String password;
    private String authority;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
