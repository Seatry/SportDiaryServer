package com.example.SportDiaryServer.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.DAY_TO_TEST;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DAY_TO_TEST)
public class DayToTest {
    @Id
    private Long id;

    @Column(name = "day_id")
    private Long dayId;

    @Column(name = "test_id")
    private Long testId;
}
