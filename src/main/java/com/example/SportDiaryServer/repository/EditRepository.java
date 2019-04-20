package com.example.SportDiaryServer.repository;

import com.example.SportDiaryServer.entity.editEntity.Edit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditRepository<T extends Edit> extends JpaRepository<T, Long> {
}
