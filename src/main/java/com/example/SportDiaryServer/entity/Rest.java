package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.REST;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = REST)
public class Rest {
    @Id
    private Long id;

    @Column(name = "day_id")
    private Long dayId;

    @Column(name = "time_id")
    private Long timeId;

    @Column(name = "place_id")
    private Long placeId;
}
