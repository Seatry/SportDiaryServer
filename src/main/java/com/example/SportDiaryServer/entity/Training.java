package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.Borg;
import com.example.SportDiaryServer.entity.editEntity.Time;
import com.example.SportDiaryServer.entity.editEntity.TrainingPlace;
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
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int capacity = 0;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Day.class)
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Long dayId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Time.class)
    @JoinColumn(name = "time_id", referencedColumnName = "id")
    private Long timeId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = TrainingPlace.class)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Long placeId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Borg.class)
    @JoinColumn(name = "borg_id", referencedColumnName = "id")
    private Long borgId;
}
