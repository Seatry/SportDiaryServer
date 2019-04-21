package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.Block;
import com.example.SportDiaryServer.entity.editEntity.Camp;
import com.example.SportDiaryServer.entity.editEntity.Stage;
import com.example.SportDiaryServer.entity.editEntity.Type;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private int capacity = 0;
    private double health = 0;
    private double mood = 0;
    private double activity = 0;
    private double dream = 0;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = CompetitionToImportance.class)
    @JoinColumn(name = "competition_to_importance_id", referencedColumnName = "id")
    private Long competitionToImportanceId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Block.class)
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    private Long blockId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Stage.class)
    @JoinColumn(name = "stage_id", referencedColumnName = "id")
    private Long stageId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Type.class)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Long typeId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Camp.class)
    @JoinColumn(name = "camp_id", referencedColumnName = "id")
    private Long campId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = SeasonPlan.class)
    @JoinColumn(name = "season_plan_id", referencedColumnName = "id")
    private Long seasonPlanId;
}
