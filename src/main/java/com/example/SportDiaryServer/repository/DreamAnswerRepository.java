package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.DreamAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DreamAnswerRepository extends JpaRepository<DreamAnswer, Long> {
}
