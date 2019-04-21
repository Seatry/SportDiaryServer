package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.DREAM_QUESTION;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DREAM_QUESTION)
public class DreamQuestion {
    @Id
    private Long id;

    private String question;
}
