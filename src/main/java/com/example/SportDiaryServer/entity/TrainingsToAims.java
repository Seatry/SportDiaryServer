package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.Aim;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Training.class)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Long trainingId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Aim.class)
    @JoinColumn(name = "aim_id", referencedColumnName = "id")
    private Long aimId;
}
