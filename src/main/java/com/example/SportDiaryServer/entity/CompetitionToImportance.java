package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.COMPETITION_TO_IMPORTANCE;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = COMPETITION_TO_IMPORTANCE)
public class CompetitionToImportance {
    @Id
    private Long id;

    @Column(name = "competition_id")
    private Long competitionId;

    @Column(name = "importance_id")
    private Long importanceId;
}
