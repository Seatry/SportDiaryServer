package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.TrainingsToAims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsToAimsRepository extends JpaRepository<TrainingsToAims, Long> {
}
