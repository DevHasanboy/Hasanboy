package com.example.hasanboy.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    private String field;
    private String  message;
}
