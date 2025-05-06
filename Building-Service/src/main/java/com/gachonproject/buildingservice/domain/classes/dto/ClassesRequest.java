package com.gachonproject.buildingservice.domain.classes.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
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
    @NotBlank private String floor;
}
