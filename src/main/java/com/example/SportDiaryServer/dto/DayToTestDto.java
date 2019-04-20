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
public class DayToTestDto {
    private Long id;

    @JsonProperty("day_id")
    private Long dayId;

    @JsonProperty("test_id")
    private Long testId;
}
