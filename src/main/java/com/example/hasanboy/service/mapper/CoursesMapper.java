package com.example.hasanboy.service.mapper;

import com.example.hasanboy.dto.CoursesDto;
import com.example.hasanboy.model.Courses;

import org.springframework.stereotype.Component;

@Component

public class CoursesMapper {
    public Courses toEntity(CoursesDto dto) {
        Courses courses=new Courses();
           courses.setDescription(dto.getDescription());
           courses.setDurationDays(dto.getDurationDays());
           courses.setPerWeek(dto.getPerWeek());
           courses.setName(dto.getName());
           courses.setDurationHours(dto.getDurationHours());
           courses.setDurationMonth(dto.getDurationMonth());
           return courses;
    }

    public CoursesDto toDto(Courses entity) {
        CoursesDto coursesDto=new CoursesDto();
        coursesDto.setDescription(coursesDto.getDescription());
        coursesDto.setId(entity.getId());
        coursesDto.setDurationDays(entity.getDurationDays());
        coursesDto.setPerWeek(entity.getPerWeek());
        coursesDto.setDurationMonth(entity.getDurationMonth());
        coursesDto.setDurationHours(entity.getDurationHours());
        coursesDto.setCreatedAt(entity.getCreatedAt());
        coursesDto.setDurationHours(entity.getDurationHours());
        coursesDto.setUpdatedAt(entity.getUpdatedAt());
        return coursesDto;
    }

    public void updateWithDto(CoursesDto dto, Courses courses) {


    }
}
