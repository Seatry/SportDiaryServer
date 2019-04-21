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

    @Column(name = "userid")
    private String userId;

    private String name;
    private Date start;
    private String male = "M";

    @Column(name = "hrmax")
    private int hrMax = 200;

    @Column(name = "hrrest")
    private int hrRest = 60;

    @Column(name = "lastperformance")
    private int lastPerformance = 0;
}
