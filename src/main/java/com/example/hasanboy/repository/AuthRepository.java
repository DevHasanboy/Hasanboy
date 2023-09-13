package com.example.hasanboy.repository;

import com.example.hasanboy.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthRepository extends JpaRepository<Auth,Integer> {

    Optional<Auth> findByAuthIdAndDeletedAtIsNull(Integer authId);
    Optional<Auth> findByUsernameAndEnabledIsTrueAndDeletedAtIsNull(String username);
}
