package com.example.hasanboy.repository;

import com.example.hasanboy.model.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons,Integer> {

    Optional<Lessons> findByIdAndDeletedAtIsNull(Integer entityId);
}
