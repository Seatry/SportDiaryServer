package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.TRAINING_EXERCISE;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = TRAINING_EXERCISE)
public class TrainingExercise {
    @Id
    private Long id;

    private int work = 1;
    private int rest = 1;
    private int length = 0;
    private int repeats = 0;
    private int series = 0;
    private String note = "";
    private int minutes = 0;

    @Column(name = "hravg")
    private double hrAvg = 0;

    @Column(name = "training_id")
    private Long trainingId;

    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column(name = "style_id")
    private Long styleId;

    @Column(name = "tempo_id")
    private Long tempoId;

    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name = "borg_id")
    private Long borgId;
}
