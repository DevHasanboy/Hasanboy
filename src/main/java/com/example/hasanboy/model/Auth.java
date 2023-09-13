package com.example.hasanboy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
public class Auth {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer authId;

    private String username;
    private String password;
    private Boolean enabled;

    @OneToMany(mappedBy = "username",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Authorities> authorities;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;

}
