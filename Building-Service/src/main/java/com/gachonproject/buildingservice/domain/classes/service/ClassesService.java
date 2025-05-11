package com.gachonproject.buildingservice.domain.classes.service;

import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClassesService {

    /** 페이징된 전체 조회 */
    Page<ClassesDto> getAll(Pageable pageable);

    /** 상세 조회 */
    ClassesDto getById(Long id);

    /** 생성 */
    ClassesDto create(ClassesRequest req);

    /** 수정 */
    ClassesDto update(Long id, ClassesRequest req);

    /** 삭제 */
    void delete(Long id);

    List<ClassesDto> getDetailList(String buildingName, String floor, int pageNum, int pageSize);
}
