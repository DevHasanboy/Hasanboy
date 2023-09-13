package com.example.hasanboy.service;

import com.example.hasanboy.dto.CoursesDto;
import com.example.hasanboy.dto.LessonsDto;
import com.example.hasanboy.dto.ResponseDto;
import com.example.hasanboy.dto.SimpleCrud;
import com.example.hasanboy.model.Courses;
import com.example.hasanboy.model.Lessons;
import com.example.hasanboy.repository.CoursesRepository;
import com.example.hasanboy.service.mapper.CoursesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesService implements SimpleCrud<Integer, CoursesDto> {
    private final CoursesMapper coursesMapper;
    private final CoursesRepository coursesRepository;
    @Override
    public ResponseDto<CoursesDto> create(CoursesDto dto) {
        try {
           Courses courses=this.coursesMapper.toEntity(dto);
            courses.setCreatedAt(LocalDateTime.now());

            return ResponseDto.<CoursesDto>builder()
                    .success(true)
                    .message("ok")
                    .data(this.coursesMapper.toDto(
                            this.coursesMapper.toEntity(dto)
                    ))
                    .build();
        }
        catch (Exception e){

            return ResponseDto.<CoursesDto>builder()
                    .code(-1)
                    .message("while is saving")
                    .build();
        }


    }


    @Override
    public ResponseDto<CoursesDto> get(Integer entityId) {
        Optional<Courses> optional=this.coursesRepository.findByIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()){
            return ResponseDto.<CoursesDto>builder()
                    .code(-1)
                    .message("not found of id")
                    .build();
        }
        return ResponseDto.<CoursesDto>builder()
                .success(true)
                .message("ok")
                .data(this.coursesMapper.toDto(optional.get()))
                .build();

    }

    @Override
    public ResponseDto<CoursesDto> delete(Integer entityId) {
        Optional<Courses> optional=this.coursesRepository.findByIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()){
            return ResponseDto.<CoursesDto>builder()
                    .code(-1)
                    .message("not found of id")
                    .build();
        }
        optional.get().setDeletedAt(LocalDateTime.now());
        return ResponseDto.<CoursesDto>builder()
                .success(true)
                .message("ok")
                .data(this.coursesMapper.toDto(optional.get()))
                .build();
    }

    @Override
    public ResponseDto<CoursesDto> update(Integer entityId, CoursesDto dto) {
        try {
            Optional<Courses> optional=this.coursesRepository.findByIdAndDeletedAtIsNull(entityId);
            if (optional.isEmpty()){
                return ResponseDto.<CoursesDto>builder()
                        .code(-1)
                        .message("not found of id")
                        .build();
            }
           Courses courses=optional.get();
            this.coursesMapper.updateWithDto(dto,courses);
            courses.setUpdatedAt(LocalDateTime.now());
           coursesRepository.save(courses);
            return ResponseDto.<CoursesDto>builder()
                    .success(true)
                    .message("ok")
                    .data(this.coursesMapper.toDto(courses))
                    .build();
        }
        catch (Exception e){

            return ResponseDto.<CoursesDto>builder()
                    .code(-1)
                    .message("not found of id")
                    .build();
        }
    }
}
