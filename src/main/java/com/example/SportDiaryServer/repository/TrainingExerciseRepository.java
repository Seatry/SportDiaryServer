package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Long> {
}
