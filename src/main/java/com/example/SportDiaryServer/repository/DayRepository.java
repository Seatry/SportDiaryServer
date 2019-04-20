package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Long> {
}
