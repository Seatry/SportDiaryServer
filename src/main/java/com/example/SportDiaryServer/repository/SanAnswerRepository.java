package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.SanAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanAnswerRepository extends JpaRepository<SanAnswer, Long> {
}
