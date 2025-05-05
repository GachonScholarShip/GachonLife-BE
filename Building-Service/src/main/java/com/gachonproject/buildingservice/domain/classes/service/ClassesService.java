package com.gachonproject.buildingservice.domain.classes.service;

import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesRequest;

import java.util.List;

public interface ClassesService {

    // 사용자 (Member)
    List<ClassesDto> getAll();
    ClassesDto getById(Long id);

    // 관리자 (Admin)
    ClassesDto create(ClassesRequest req);
    ClassesDto update(Long id, ClassesRequest req);
    void delete(Long id);
}
