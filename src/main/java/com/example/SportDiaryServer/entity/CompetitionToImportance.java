package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.Competition;
import com.example.SportDiaryServer.entity.editEntity.Importance;
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
public class CompetitionToImportance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Competition.class)
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Long competitionId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = Importance.class)
    @JoinColumn(name = "importance_id", referencedColumnName = "id")
    private Long importanceId;
}
