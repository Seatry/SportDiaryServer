package com.example.SportDiaryServer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.TRAINING;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = TRAINING)
public class Training {
    @Id
    private Long id;

    private int capacity = 0;

    @Column(name = "day_id")
    private Long dayId;

    @Column(name = "time_id")
    private Long timeId;

    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "borg_id")
    private Long borgId;
}
