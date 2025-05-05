package com.gachonproject.buildingservice.domain.classes.dto;

import lombok.*;
@Getter @Setter @AllArgsConstructor

public class ClassesDto {
    private Long id;
    private String code;
    private String title;
    private String grade;
    private String major;
    private String professor;
    private String courseTime;
    private String timeSlot;
    private String buildingName;
    private String roomName;
    private Integer floor;
}
