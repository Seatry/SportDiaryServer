package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.Rest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestRepository extends JpaRepository<Rest, Long> {
    List<Rest> findAllByDayId(Long DayId);
}
