package com.gachonproject.buildingservice.domain.classes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "code", nullable = false, unique = true)
    private String code;


    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "grade", nullable = false)
    private String grade;


    @Column(name = "major", nullable = false)
    private String major;


    @Column(name = "professor", nullable = false)
    private String professor;


    @Column(name = "course_time", nullable = false)
    private String courseTime;


    @Column(name = "timeslot", nullable = false)
    private String timeSlot;


    @Column(name = "building_name", nullable = false)
    private String buildingName;


    @Column(name = "room_name", nullable = false)
    private String roomName;


    @Column(name = "floor", nullable = false)
    private String floor;


    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
