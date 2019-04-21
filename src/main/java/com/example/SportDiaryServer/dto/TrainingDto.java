package com.example.SportDiaryServer.dto;

import com.example.SportDiaryServer.entity.TrainingExercise;
import com.example.SportDiaryServer.entity.TrainingsToAims;
import com.example.SportDiaryServer.entity.TrainingsToEquipments;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDto {
    private Long id;
    private int capacity;

    @JsonProperty("day_id")
    private Long dayId;

    @JsonProperty("time_id")
    private Long timeId;

    @JsonProperty("borg_id")
    private Long borgId;

    @JsonProperty("place_id")
    private Long placeId;

    private List<TrainingExerciseDto> trainingExercises;

    private List<TrainingsToAimsDto> trainingsToAims;

    private List<TrainingsToEquipmentsDto> trainingsToEquipments;
}
