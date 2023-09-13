package com.example.hasanboy.controller;

import com.example.hasanboy.dto.CoursesDto;
import com.example.hasanboy.dto.ResponseDto;
import com.example.hasanboy.dto.SimpleCrud;
import com.example.hasanboy.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cours")
@RequiredArgsConstructor
public class CoursesController implements SimpleCrud<Integer, CoursesDto> {
    private final CoursesService coursesService;
    @PostMapping
    @Override
    public ResponseDto<CoursesDto> create(@RequestBody CoursesDto dto) {
        return this.coursesService.create(dto);
    }
@GetMapping("/{id}")
    @Override
    public ResponseDto<CoursesDto> get(@PathVariable(value = "id") Integer entityId) {
        return this.coursesService.get(entityId);
    }
@DeleteMapping("/{id}")
    @Override
    public ResponseDto<CoursesDto> delete(@PathVariable(value = "id") Integer entityId) {
        return this.coursesService.delete(entityId);
    }
@PostMapping("/{id}")
    @Override
    public ResponseDto<CoursesDto> update(@PathVariable(value = "id") Integer entityId, @RequestBody CoursesDto dto) {
        return this.coursesService.update(entityId, dto);
    }
}
