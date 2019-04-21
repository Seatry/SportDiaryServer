package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.SeasonPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonPlanRepository extends JpaRepository<SeasonPlan, Long> {
    List<SeasonPlan> findAllByUserId(String userId);
}
