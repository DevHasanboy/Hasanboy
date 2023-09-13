package com.example.hasanboy.controller;

import com.example.hasanboy.dto.AuthDto;
import com.example.hasanboy.dto.ResponseDto;
import com.example.hasanboy.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping
    public ResponseDto<AuthDto> createAuth(@RequestBody AuthDto dto){
        return this.authService.create(dto);
    }
    @GetMapping("/{id}")
    private ResponseDto<AuthDto> getAuth(@PathVariable (value = "id") Integer authId){
        return this.authService.getAuth(authId);
    }



}
