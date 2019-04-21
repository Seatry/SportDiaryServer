package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.SanQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanQuestionRepository extends JpaRepository<SanQuestion, Long> {
}
