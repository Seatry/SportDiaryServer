package com.example.SportDiaryServer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.example.SportDiaryServer.enums.Table.VERSION;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = VERSION)
public class Version {
    @Id
    private Long id;

    @Column(name = "userid")
    private String userId;

    private Long version = 0L;
}
