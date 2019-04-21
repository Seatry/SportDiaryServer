package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.TrainingsToEquipments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingsToEquipmentsRepository extends JpaRepository<TrainingsToEquipments, Long> {
    List<TrainingsToEquipments> findAllByTrainingId(Long trainingId);
}
