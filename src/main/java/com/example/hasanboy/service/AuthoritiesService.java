package com.example.hasanboy.service;

import com.example.hasanboy.dto.AuthoritiesDto;
import com.example.hasanboy.dto.ResponseDto;
import com.example.hasanboy.dto.SimpleCrud;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService implements SimpleCrud<Integer, AuthoritiesDto> {
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
