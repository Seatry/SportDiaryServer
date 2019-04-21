package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Long> {
    List<TrainingExercise> findAllByTrainingId(Long trainingId);
}
