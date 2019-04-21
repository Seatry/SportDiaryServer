package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

import static com.example.SportDiaryServer.enums.Table.SEASON_PLAN;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = SEASON_PLAN)
public class SeasonPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String name;
    private Date start;
    private String male = "M";
    private int hrMax = 200;
    private int hrRest = 60;
    private int lastPerformance = 0;
}
