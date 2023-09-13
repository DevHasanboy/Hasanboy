package com.example.hasanboy.service.validation;

import com.example.hasanboy.dto.CoursesDto;
import com.example.hasanboy.dto.ErrorDto;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoursesValidation {

    public List<ErrorDto> validate(CoursesDto coursesDto){
        List<ErrorDto> list=new ArrayList<>();
        if (StringUtils.isBlank(coursesDto.getId().toString())) {
           list.add(new ErrorDto("id","id cannot be null or empty"));

        }
        if (StringUtils.isBlank(coursesDto.getName())) {
            list.add(new ErrorDto("name","name cannot be null or empty"));

        }
        if (StringUtils.isBlank(coursesDto.getType())) {
            list.add(new ErrorDto("type","type cannot be null or empty"));

        }
        if (StringUtils.isBlank(coursesDto.getDescription())) {
            list.add(new ErrorDto("description","description cannot be null or empty"));

        }
        if (StringUtils.isBlank(coursesDto.getDurationDays().toString())) {
            list.add(new ErrorDto("DurationDays","DurationDayscannot be null or empty"));

        }
        if (StringUtils.isBlank(coursesDto.getDurationHours().toString())) {
            list.add(new ErrorDto("DurationHours","DurationHours cannot be null or empty"));

        }
        if (StringUtils.isBlank(coursesDto.getDurationMonth().toString())) {
            list.add(new ErrorDto("durationMonth","durationMonth cannot be null or empty"));

        }
        if (StringUtils.isBlank(coursesDto.getPerWeek().toString())) {
            list.add(new ErrorDto("PerWeek","PerWeek cannot be null or empty"));

        }
        return list;
    }
}
