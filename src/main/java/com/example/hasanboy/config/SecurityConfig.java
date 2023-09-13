package com.example.hasanboy.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;


    @Autowired
    public void authenticationManagerBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username from auth as users  where username=?")
                .passwordEncoder(passwordEncoder);
    }

//@Autowired todo:inMemoryAuthentication
//    public void authenticationManagerBuilder(AuthenticationManagerBuilder builder) throws Exception {
//         builder.inMemoryAuthentication()
//                .withUser("Hasanboy")
//                .password(passwordEncoder.encode("7777777"))
//                .roles("Admin")
//                .and().
//                passwordEncoder(passwordEncoder);
//    }

@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf().disable()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and()
                .build();

    }
}
