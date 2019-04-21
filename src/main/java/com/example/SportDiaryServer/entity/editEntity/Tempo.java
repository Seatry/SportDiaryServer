package com.example.SportDiaryServer.entity.editEntity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.TEMPO;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = TEMPO)
public class Tempo extends Edit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
