package com.example.SportDiaryServer.entity.editEntity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.STAGE;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = STAGE)
public class Stage extends Edit {
    @Id
    private Long id;

    @Column(name = "userid")
    private String userId;

    private String name;
}
