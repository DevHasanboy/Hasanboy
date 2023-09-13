package com.example.hasanboy.service.mapper;

import com.example.hasanboy.dto.AuthDto;
import com.example.hasanboy.model.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthMapper{

   private final PasswordEncoder passwordEncoder;
    private final AuthoritiesMapper authoritiesMapper;

    public Auth toEntity(AuthDto dto){
        return Auth.builder()
                .username(dto.getUsername())
               .password(passwordEncoder.encode(dto.getPassword())    )
                .enabled(true)
                .build();
    }

    public AuthDto toDot(Auth save){

        return AuthDto.builder()
                .authId(save.getAuthId())
                .username(save.getUsername())
                .password(save.getPassword())
                .enabled(save.getEnabled())
                .createdAt(save.getCreatedAt())
                .deletedAt(save.getDeletedAt())
                .updatedAt(save.getUpdatedAt())
                .build();
    }

    public AuthDto toDtoWithAuthority(Auth auth){

        return AuthDto.builder()
                .authId(auth.getAuthId())
                .authorities(auth.getAuthorities().stream().map(this.authoritiesMapper::toDto).toList())
                .username(auth.getUsername())
                .password(auth.getPassword())
                .enabled(auth.getEnabled())
                .createdAt(auth.getCreatedAt())
                .deletedAt(auth.getDeletedAt())
                .updatedAt(auth.getUpdatedAt())
                .build();

    }



}
