package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.entity.editEntity.Test;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Day.class)
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Long dayId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, targetEntity = Test.class)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Long testId;
}
