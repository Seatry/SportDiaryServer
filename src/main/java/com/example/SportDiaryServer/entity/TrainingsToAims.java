package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.TRAININGS_TO_AIMS;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = TRAININGS_TO_AIMS)
public class TrainingsToAims {
    @Id
    private Long id;

    @Column(name = "training_id")
    private Long trainingId;

    @Column(name = "aim_id")
    private Long aimId;
}
