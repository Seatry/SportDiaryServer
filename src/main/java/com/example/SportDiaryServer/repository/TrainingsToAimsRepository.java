package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.TrainingsToAims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingsToAimsRepository extends JpaRepository<TrainingsToAims, Long> {
    List<TrainingsToAims> findAllByTrainingId(Long trainingId);
}
