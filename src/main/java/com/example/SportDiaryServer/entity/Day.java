package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

import static com.example.SportDiaryServer.enums.Table.DAY;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DAY)
public class Day {
    @Id
    private Long id;

    private Date date;
    private int capacity = 0;
    private double health = 0;
    private double mood = 0;
    private double activity = 0;
    private double dream = 0;

    @Column(name = "competition_to_importance_id")
    private Long competitionToImportanceId;

    @Column(name = "block_id")
    private Long blockId;

    @Column(name = "stage_id")
    private Long stageId;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "camp_id")
    private Long campId;

    @Column(name = "season_plan_id")
    private Long seasonPlanId;
}
