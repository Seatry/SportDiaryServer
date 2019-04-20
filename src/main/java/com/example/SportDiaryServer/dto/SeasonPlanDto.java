package com.example.SportDiaryServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonPlanDto {
    private Long id;

    private String userId;
    private String name;
    private Date start;
    private String male;
    private int hrMax;
    private int hrRest;
    private int lastPerformance;
}
