package com.example.hasanboy.service.mapper;

import com.example.hasanboy.dto.LessonsDto;
import com.example.hasanboy.model.Lessons;
import com.fasterxml.classmate.AnnotationOverrides;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class LessonsMapper {
    public Lessons toEntity(LessonsDto dto) {
        return null;
    }

    public LessonsDto toDto(Lessons entity) {
        return null;
    }

    public void updateWithDto(LessonsDto dto, Lessons lessons) {
    }
}
