package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.CompetitionToImportance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionToImportanceRepository extends JpaRepository<CompetitionToImportance, Long> {
}
