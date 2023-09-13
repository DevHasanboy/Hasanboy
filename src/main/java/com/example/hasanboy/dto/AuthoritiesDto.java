package com.example.hasanboy.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthoritiesDto {
    private Integer authorityId;
    private String  username;
    private String password;
    private String authority;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
