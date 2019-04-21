package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.DreamAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DreamAnswerRepository extends JpaRepository<DreamAnswer, Long> {
    List<DreamAnswer> findAllByDayId(Long dayId);
}
