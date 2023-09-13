package com.example.hasanboy.service.mapper;

import com.example.hasanboy.dto.AuthoritiesDto;
import com.example.hasanboy.model.Authorities;
import org.springframework.stereotype.Component;

@Component
public class AuthoritiesMapper {

    public Authorities toEntity(AuthoritiesDto dto){
        return Authorities.builder()
                .authority(dto.getAuthority())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
    }
    public AuthoritiesDto toDto(Authorities authorities){
        return AuthoritiesDto.builder()
                .authorityId(authorities.getAuthorityId())
                .authority(authorities.getAuthority())
                .username(authorities.getUsername())
                .password(authorities.getPassword())
                .createdAt(authorities.getCreatedAt())
                .updatedAt(authorities.getUpdatedAt())
                .deletedAt(authorities.getDeletedAt())
                .build();
    }
}
