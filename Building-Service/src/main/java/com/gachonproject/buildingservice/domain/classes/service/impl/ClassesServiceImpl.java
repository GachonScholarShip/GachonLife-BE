package com.gachonproject.buildingservice.domain.classes.service.impl;

import com.gachonproject.buildingservice.domain.classes.entity.Classes;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesRequest;
import com.gachonproject.buildingservice.domain.classes.repository.ClassesRepository;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassesServiceImpl implements ClassesService {

    private final ClassesRepository repo;

    // ── 관리자 & 사용자 공통 ──

    /** 페이징된 전체 조회 */
    @Override
    public Page<ClassesDto> getAll(Pageable pageable) {
        return repo.findAll(pageable)
                .map(this::toDto);
    }

    /** ID 로 상세 조회 */
    @Override
    public ClassesDto getById(Long id) {
        Classes cls = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 강의실 ID: " + id));
        return toDto(cls);
    }

    // ── 관리자 전용 ──

    /** 생성 */
    @Override
    public ClassesDto create(ClassesRequest req) {
        Classes cls = new Classes();
        cls.setCode(req.getCode());
        cls.setTitle(req.getTitle());
        cls.setGrade(req.getGrade());
        cls.setMajor(req.getMajor());
        cls.setProfessor(req.getProfessor());
        cls.setCourseTime(req.getCourseTime());
        cls.setTimeSlot(req.getTimeSlot());
        cls.setBuildingName(req.getBuildingName());
        cls.setRoomName(req.getRoomName());

        // 원본 floorRaw 에서 F/f 뒤 제거
        cls.setFloor(normalizeFloor(req.getFloorRaw()));
        Classes saved = repo.save(cls);
        return toDto(saved);
    }

    /** 수정 */
    @Override
    public ClassesDto update(Long id, ClassesRequest req) {
        Classes cls = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 강의실 ID: " + id));
        cls.setCode(req.getCode());
        cls.setTitle(req.getTitle());
        cls.setGrade(req.getGrade());
        cls.setMajor(req.getMajor());
        cls.setProfessor(req.getProfessor());
        cls.setCourseTime(req.getCourseTime());
        cls.setTimeSlot(req.getTimeSlot());
        cls.setBuildingName(req.getBuildingName());
        cls.setRoomName(req.getRoomName());
        // 원본 floorRaw 에서 F/f 뒤 제거
        cls.setFloor(normalizeFloor(req.getFloorRaw()));
        cls.setUpdatedAt(LocalDateTime.now());
        Classes updated = repo.save(cls);
        return toDto(updated);
    }

    /** 삭제 */
    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("존재하지 않는 강의실 ID: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public List<ClassesDto> getDetailList(String buildingName, String floor, int pageNum, int pageSize) {
        return List.of();
    }

    private String normalizeFloor(String raw) {
        raw = raw.strip();
        if (raw.length() > 1 && (raw.endsWith("F") || raw.endsWith("f"))) {
            return raw.substring(0, raw.length() - 1);
        }
        return raw;
    }

    /** 엔티티 → DTO 변환 */
    private ClassesDto toDto(Classes cls) {
        return new ClassesDto(
                cls.getId(),
                cls.getCode(),
                cls.getTitle(),
                cls.getGrade(),
                cls.getMajor(),
                cls.getProfessor(),
                cls.getCourseTime(),
                cls.getTimeSlot(),
                cls.getBuildingName(),
                cls.getRoomName(),
                cls.getFloor()   // 이제 String 타입
        );
    }
}
