package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.DREAM_ANSWER;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DREAM_ANSWER)
public class DreamAnswer {
    @Id
    private Long id;

    private int answer;

    @Column(name = "day_id")
    private Long dayId;

    @Column(name = "question_id")
    private Long questionId;
}
