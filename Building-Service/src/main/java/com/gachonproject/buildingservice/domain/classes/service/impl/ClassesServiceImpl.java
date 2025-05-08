package com.gachonproject.buildingservice.domain.classes.service.impl;

import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesRequest;
import com.gachonproject.buildingservice.domain.classes.entity.Classes;
import com.gachonproject.buildingservice.domain.classes.repository.ClassesRepository;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        cls.setFloor(req.getFloor());
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
        cls.setFloor(req.getFloor());
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

        Pageable pageable = PageRequest.of(pageNum, pageSize);

        if (floor.equals("0")) { // 모든 건물 페이지네이션
            return repo.findByBuildingName(buildingName, pageable)
                    .getContent()
                    .stream()
                    .map(this::toDto)
                    .toList();
        }

        return repo.findByBuildingNameAndFloor(buildingName, floor, pageable)
                .getContent()
                .stream()
                .map(this::toDto)
                .toList();
    }

    /** 엔티티 → DTO 변환 헬퍼 */
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
                cls.getFloor()
        );
    }
}
