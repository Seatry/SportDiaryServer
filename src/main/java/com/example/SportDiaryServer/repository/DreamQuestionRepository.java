package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.DreamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DreamQuestionRepository extends JpaRepository<DreamQuestion, Long> {
}
