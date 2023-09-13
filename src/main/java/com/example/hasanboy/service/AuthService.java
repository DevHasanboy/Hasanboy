package com.example.hasanboy.service;

import com.example.hasanboy.dto.AuthDto;
import com.example.hasanboy.dto.ResponseDto;
import com.example.hasanboy.model.Auth;
import com.example.hasanboy.repository.AuthRepository;
import com.example.hasanboy.service.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService  implements UserDetailsService {
    private final AuthMapper authMapper;
    private final AuthRepository authRepository;

    public ResponseDto<AuthDto> create(AuthDto dto) {
        try {


           var entity= this.authMapper.toEntity(dto);
           entity.setCreatedAt(LocalDateTime.now());

            return ResponseDto.<AuthDto>builder()
                    .success(true)
                    .message("ok")
                    .data(this.authMapper.toDot(
                            this.authRepository.save(
                                 entity
                            )
                    ))
                    .build();
        }catch (Exception e){
            return ResponseDto.<AuthDto>builder()
                    .code(-1)
                    .message("while is saving error")
                    .build();

        }
    }

    public ResponseDto<AuthDto> getAuth(Integer authId) {
        Optional<Auth> optional=this.authRepository.findByAuthIdAndDeletedAtIsNull(authId);
        if (optional.isEmpty()){
            return ResponseDto.<AuthDto>builder()
                    .code(-1)
                    .message("not found of id")
                    .build();
        }
        return ResponseDto.<AuthDto>builder()
                .success(true)
                .message("ok")
                .data(this.authMapper.toDot(optional.get()))
                .build();
    }

    @Override
    public AuthDto loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.authRepository.findByUsernameAndEnabledIsTrueAndDeletedAtIsNull(username)
                .map(this.authMapper::toDot)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Auth with %s :: username is not found",username)));
    }
}
