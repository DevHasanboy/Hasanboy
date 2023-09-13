package com.example.hasanboy.controller;

import com.example.hasanboy.dto.LessonsDto;
import com.example.hasanboy.dto.ResponseDto;
import com.example.hasanboy.dto.SimpleCrud;
import com.example.hasanboy.service.LessonsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "less")
@RestController
@RequiredArgsConstructor
public class LessonsController implements SimpleCrud<Integer, LessonsDto> {
    private final LessonsService lessonsService;
    @PostMapping
    @Override
    public ResponseDto<LessonsDto> create(@RequestBody @Valid LessonsDto dto) {
        return this.lessonsService.create(dto);
    }
@GetMapping("/{id}")
    @Override
    public ResponseDto<LessonsDto> get(@PathVariable(value = "id") Integer entityId) {
        return this.lessonsService.get(entityId);
    }
@DeleteMapping("/{id}")
    @Override
    public ResponseDto<LessonsDto> delete(@PathVariable(value = "id") Integer entityId) {
        return this.lessonsService.delete(entityId);
    }
@PutMapping("/{id}")
    @Override
    public ResponseDto<LessonsDto> update(@PathVariable(value = "id") Integer entityId,@RequestBody LessonsDto dto) {
        return this.lessonsService.update(entityId, dto);
    }
}
