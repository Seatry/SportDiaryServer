package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.Equipment;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.TRAININGS_TO_EQUIPMENTS;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = TRAININGS_TO_EQUIPMENTS)
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
