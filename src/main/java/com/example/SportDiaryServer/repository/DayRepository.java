package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
    List<Day> findAllBySeasonPlanId(Long seasonPlanId);
}
