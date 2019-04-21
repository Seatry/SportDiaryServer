package com.example.SportDiaryServer.entity.editEntity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.TRAINING_PLACE;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = TRAINING_PLACE)
public class TrainingPlace extends Edit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
