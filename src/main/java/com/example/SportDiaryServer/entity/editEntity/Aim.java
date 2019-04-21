package com.example.SportDiaryServer.entity.editEntity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.AIM;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = AIM)
public class Aim extends Edit {
    @Id
    private Long id;

    @Column(name = "userid")
    private String userId;

    private String name;
}
