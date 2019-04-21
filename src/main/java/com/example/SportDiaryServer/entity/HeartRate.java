package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.HEART_RATE;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = HEART_RATE)
public class HeartRate {
    @Id
    private Long id;

    private String time;
    private int series;
    private int repeat;
    private int hr = 0;

    @Column(name = "exercise_id")
    private Long exerciseId;
}
