package com.example.hasanboy.service;

import com.example.hasanboy.dto.ErrorDto;
import com.example.hasanboy.dto.LessonsDto;
import com.example.hasanboy.dto.ResponseDto;
import com.example.hasanboy.dto.SimpleCrud;
import com.example.hasanboy.model.Lessons;
import com.example.hasanboy.repository.LessonsRepository;
import com.example.hasanboy.service.mapper.LessonsMapper;
import com.example.hasanboy.service.validation.LessonsValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonsService implements SimpleCrud<Integer, LessonsDto> {
    private final LessonsMapper lessonsMapper;
    private final LessonsRepository lessonsRepository;
  private final   LessonsValidation lessonsValidation;
    @Override
    public ResponseDto<LessonsDto> create(LessonsDto dto) {

        List<ErrorDto> errors=this.lessonsValidation.validate(dto);
        if (errors.isEmpty()){
            return ResponseDto.<LessonsDto>builder()
                    .code(-3)
                    .message("error")
                    .errors(errors)
                    .build();
        }
        try {
            Lessons lessons=this.lessonsMapper.toEntity(dto);
            lessons.setCreatedAt(LocalDateTime.now());

            return ResponseDto.<LessonsDto>builder()
                    .success(true)
                    .message("ok")
                    .data(this.lessonsMapper.toDto(
                                    this.lessonsMapper.toEntity(dto)
                            ))
                    .build();
        }
        catch (Exception e){

            return ResponseDto.<LessonsDto>builder()
                    .code(-1)
                    .message("while is saving")
                    .build();
        }


    }

    @Override
    public ResponseDto<LessonsDto> get(Integer entityId) {
        Optional<Lessons> optional=this.lessonsRepository.findByIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()){
            return ResponseDto.<LessonsDto>builder()
                    .code(-1)
                    .message("not found of id")
                    .build();
        }
        return ResponseDto.<LessonsDto>builder()
                .success(true)
                .message("ok")
                .data(this.lessonsMapper.toDto(optional.get()))
                .build();

    }

    @Override
    public ResponseDto<LessonsDto> delete(Integer entityId) {
        Optional<Lessons> optional=this.lessonsRepository.findByIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()){
            return ResponseDto.<LessonsDto>builder()
                    .code(-1)
                    .message("not found of id")
                    .build();
        }
        optional.get().setDeletedAt(LocalDateTime.now());
        return ResponseDto.<LessonsDto>builder()
                .success(true)
                .message("ok")
                .data(this.lessonsMapper.toDto(optional.get()))
                .build();
    }

    @Override
    public ResponseDto<LessonsDto> update(Integer entityId, LessonsDto dto) {
        try {
            Optional<Lessons> optional=this.lessonsRepository.findByIdAndDeletedAtIsNull(entityId);
            if (optional.isEmpty()){
                return ResponseDto.<LessonsDto>builder()
                        .code(-1)
                        .message("not found of id")
                        .build();
            }
            Lessons lessons=optional.get();
            this.lessonsMapper.updateWithDto(dto,lessons);
            lessons.setUpdatedAt(LocalDateTime.now());
            lessonsRepository.save(lessons);
            return ResponseDto.<LessonsDto>builder()
                    .success(true)
                    .message("ok")
                    .data(this.lessonsMapper.toDto(lessons))
                    .build();
        }
        catch (Exception e){

            return ResponseDto.<LessonsDto>builder()
                    .code(-1)
                    .message("not found of id")
                    .build();
        }
    }
}
