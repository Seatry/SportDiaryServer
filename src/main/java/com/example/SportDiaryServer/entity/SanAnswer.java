package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.SAN_ANSWER;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = SAN_ANSWER)
public class SanAnswer {
    @Id
    private Long id;

    private int answer;

    @Column(name = "day_id")
    private Long dayId;

    @Column(name = "question_id")
    private Long questionId;
}
