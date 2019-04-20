package com.example.SportDiaryServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingExerciseDto {
    private Long id;
    private int work;
    private int rest;
    private int length;
    private int repeats;
    private int series;
    private String note;
    private int minutes;
    private double hrAvg;

    @JsonProperty("training_id")
    private Long trainingId;

    @JsonProperty("exercise_id")
    private Long exerciseId;

    @JsonProperty("style_id")
    private Long styleId;

    @JsonProperty("tempo_id")
    private Long tempoId;

    @JsonProperty("zone_id")
    private Long zoneId;

    @JsonProperty("borg_id")
    private Long borgId;
}
