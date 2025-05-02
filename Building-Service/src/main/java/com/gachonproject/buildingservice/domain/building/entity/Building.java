package com.gachonproject.buildingservice.domain.building.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
@Getter
@Setter
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="building_name", nullable=false, unique=true)
    private String buildingName;

    @Column(name="top_floor", nullable=false)
    private Integer topFloor;

    @Column(name="bottom_floor", nullable=false)
    private Integer bottomFloor;

    @Column(name="is_public", nullable=false)
    private Boolean isPublic;

    @Column(name="createdat", updatable=false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name="updatedat")
    private LocalDateTime updatedAt = LocalDateTime.now();

    /**
     * bottomFloor 부터 topFloor 까지
     * B1,B2... 과 1,2,3... 형식의 리스트를 리턴
     */
    public List<String> getFloors() {
        List<String> floors = new ArrayList<>();
        for (int f = bottomFloor; f <= topFloor; f++) {
            if (f < 0) {
                floors.add("B" + Math.abs(f));
            } else {
                floors.add(String.valueOf(f));
            }
        }
        return floors;
    }
}
