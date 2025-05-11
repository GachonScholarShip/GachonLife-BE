package com.gachonproject.buildingservice.domain.classes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ClassesRequest {
    @NotBlank private String code;
    @NotBlank private String title;
    @NotBlank private String grade;
    @NotBlank private String major;
    @NotBlank private String professor;
    @NotBlank private String courseTime;
    @NotBlank private String timeSlot;
    @NotBlank private String buildingName;
    @NotBlank private String roomName;

    @JsonProperty("floor")
    @NotBlank
    private String floorRaw;
}
