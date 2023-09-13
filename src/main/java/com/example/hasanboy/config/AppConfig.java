package com.example.hasanboy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class AppConfig {
    @Value(value = "${spring.datasource.url}")
    private String url;
    @Value(value = "${spring.datasource.password}")
    private String password;
    @Value(value = "${spring.datasource.username}")
    private String username;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource sdds=new SimpleDriverDataSource();
        sdds.setDriverClass(org.postgresql.Driver.class);
        sdds.setPassword(password);
        sdds.setUsername(username);
        sdds.setUrl(url);
        return sdds;
    }
}
