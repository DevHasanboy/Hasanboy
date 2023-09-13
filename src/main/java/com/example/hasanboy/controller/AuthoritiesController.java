package com.example.hasanboy.controller;

import com.example.hasanboy.dto.AuthoritiesDto;
import com.example.hasanboy.dto.ResponseDto;
import com.example.hasanboy.dto.SimpleCrud;
import com.example.hasanboy.repository.AuthoritiesRepository;
import com.example.hasanboy.service.AuthoritiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "authority")
@RequiredArgsConstructor
public class AuthoritiesController implements SimpleCrud<Integer, AuthoritiesDto> {

    private final AuthoritiesService authoritiesService;
    private final AuthoritiesRepository authoritiesRepository;
    @Override
    public ResponseDto<AuthoritiesDto> create(AuthoritiesDto dto) {
        return null;
    }

    @Override
    public ResponseDto<AuthoritiesDto> get(Integer entityId) {
        return null;
    }

    @Override
    public ResponseDto<AuthoritiesDto> delete(Integer entityId) {
        return null;
    }

    @Override
    public ResponseDto<AuthoritiesDto> update(Integer entityId, AuthoritiesDto dto) {
        return null;
    }
}
