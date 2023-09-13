package com.example.hasanboy.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto <T>{
    private String message;
    private int code;
    private boolean success;
    private T data;
    private List<ErrorDto> errors;
}
