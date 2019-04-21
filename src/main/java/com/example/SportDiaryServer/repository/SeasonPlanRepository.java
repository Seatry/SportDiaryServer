package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.SeasonPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonPlanRepository extends JpaRepository<SeasonPlan, Long> {
}
