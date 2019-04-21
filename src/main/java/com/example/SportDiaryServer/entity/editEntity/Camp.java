package com.example.SportDiaryServer.entity.editEntity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.CAMP;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = CAMP)
public class Camp extends Edit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
