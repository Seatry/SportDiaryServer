package com.example.SportDiaryServer.repository.editRepository;

import com.example.SportDiaryServer.entity.editEntity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempoRepository extends JpaRepository<Tempo, Long> {
    List<Tempo> findAllByUserId(String userId);
}
