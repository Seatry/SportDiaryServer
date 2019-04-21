package com.example.SportDiaryServer.repository.editRepository;

import com.example.SportDiaryServer.entity.editEntity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
