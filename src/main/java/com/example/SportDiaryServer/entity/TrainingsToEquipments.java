package com.example.SportDiaryServer.entity;

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
    private Long id;

    @Column(name = "training_id")
    private Long trainingId;

    @Column(name = "equipment_id")
    private Long equipmentId;
}
