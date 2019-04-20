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
public class SanAnswerDto {
    private Long id;

    private int answer;

    @JsonProperty("day_id")
    private Long dayId;

    @JsonProperty("question_id")
    private Long questionId;
}
