package com.example.SportDiaryServer.entity.editEntity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.TIME;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = TIME)
public class Time extends Edit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
