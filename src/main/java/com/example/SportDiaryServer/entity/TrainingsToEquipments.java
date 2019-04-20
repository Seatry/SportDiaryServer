package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.Equipment;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class TrainingsToEquipments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Training.class)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Long trainingId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Equipment.class)
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    private Long equipmentId;
}
