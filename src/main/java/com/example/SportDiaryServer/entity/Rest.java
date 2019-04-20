package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.RestPlace;
import com.example.SportDiaryServer.entity.editEntity.Time;
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
public class Rest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Day.class)
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Long dayId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Time.class)
    @JoinColumn(name = "time_id", referencedColumnName = "id")
    private Long timeId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = RestPlace.class)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Long placeId;
}
