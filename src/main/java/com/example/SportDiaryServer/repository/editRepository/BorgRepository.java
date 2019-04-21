package com.example.SportDiaryServer.repository.editRepository;

import com.example.SportDiaryServer.entity.editEntity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorgRepository extends JpaRepository<Borg, Long> {
}
