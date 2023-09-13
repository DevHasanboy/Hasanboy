package com.example.hasanboy.service.validation;

import com.example.hasanboy.dto.ErrorDto;
import com.example.hasanboy.dto.LessonsDto;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LessonsValidation {

    public List<ErrorDto> validate(LessonsDto lessonsDto){
        List<ErrorDto>list=new ArrayList<>();
        if (StringUtils.isBlank(lessonsDto.getId().toString())){
            list.add(new ErrorDto("id","id cannot be null or empty"));
        }
        if (StringUtils.isBlank(lessonsDto.getCourseId().toString())){
            list.add(new ErrorDto("courseId","courseId cannot be null or empty"));
        }
        if (StringUtils.isBlank(lessonsDto.getContent())){
            list.add(new ErrorDto("content","content cannot be null or empty"));
        }
        if (StringUtils.isBlank(lessonsDto.getTitle())){
            list.add(new ErrorDto("title","title cannot be null or empty"));
        }
        if (StringUtils.isBlank(lessonsDto.getDescription())){
            list.add(new ErrorDto("description","description cannot be null or empty"));
        }
      return list;


    }
}
