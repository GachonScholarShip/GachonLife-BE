package com.gachonproject.buildingservice.domain.classes.service.impl;

import com.gachonproject.buildingservice.domain.classes.entity.Classes;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesRequest;
import com.gachonproject.buildingservice.domain.classes.repository.ClassesRepository;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassesServiceImpl implements ClassesService {

    private final ClassesRepository repo;

    // ── 사용자 (Member) ──

    @Override
    public List<ClassesDto> getAll() {
        return repo.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ClassesDto getById(Long id) {
        Classes cls = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 강의실 ID: " + id));
        return toDto(cls);
    }

    // ── 관리자 (Admin) ──

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

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("존재하지 않는 강의실 ID: " + id);
        }
        repo.deleteById(id);
    }

    // ── 공통 DTO 변환 ──

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
