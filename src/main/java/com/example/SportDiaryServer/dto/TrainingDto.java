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
}
