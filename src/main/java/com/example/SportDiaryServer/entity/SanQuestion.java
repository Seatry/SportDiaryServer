package com.example.SportDiaryServer.entity;

import com.example.SportDiaryServer.enums.SanType;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.example.SportDiaryServer.enums.Table.SAN_QUESTION;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = SAN_QUESTION)
public class SanQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String positive;
    private String negative;

    @Enumerated(EnumType.ORDINAL)
    private SanType type;
}
