package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
    List<HeartRate> findAllByExerciseId(Long exerciseId);
}
