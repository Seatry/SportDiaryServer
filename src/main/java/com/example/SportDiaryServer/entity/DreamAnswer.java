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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int answer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Day.class)
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Long dayId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = DreamQuestion.class)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Long questionId;
}
