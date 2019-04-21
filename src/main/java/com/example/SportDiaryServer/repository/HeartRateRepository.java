package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
}
