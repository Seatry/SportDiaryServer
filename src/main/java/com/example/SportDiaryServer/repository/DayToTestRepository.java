package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.DayToTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayToTestRepository extends JpaRepository<DayToTest, Long> {
    List<DayToTest> findAllByDayId(Long dayId);
}
