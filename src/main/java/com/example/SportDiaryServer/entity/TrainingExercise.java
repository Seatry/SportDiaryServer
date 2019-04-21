package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Training.class)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Long trainingId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Exercise.class)
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private Long exerciseId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Style.class)
    @JoinColumn(name = "style_id", referencedColumnName = "id")
    private Long styleId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Tempo.class)
    @JoinColumn(name = "tempo_id", referencedColumnName = "id")
    private Long tempoId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Zone.class)
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    private Long zoneId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Borg.class)
    @JoinColumn(name = "borg_id", referencedColumnName = "id")
    private Long borgId;
}
