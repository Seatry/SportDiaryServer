package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findAllByDayId(Long dayId);
}
