package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
