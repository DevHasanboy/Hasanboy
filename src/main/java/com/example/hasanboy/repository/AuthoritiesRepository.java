package com.example.hasanboy.repository;

import com.example.hasanboy.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthoritiesRepository  extends JpaRepository<Authorities,Integer> {

    Optional<Authorities> findByAuthorityIdAndDeletedAtIsNull(Integer authorityId);
}
