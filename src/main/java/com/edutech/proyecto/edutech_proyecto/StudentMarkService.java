package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.StudentMarkDTO;
import com.edutech.proyecto.edutech_proyecto.entity.StudentMark;
import com.edutech.proyecto.edutech_proyecto.exception.ResourceNotFoundException;
import com.edutech.proyecto.edutech_proyecto.repository.StudentMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentMarkService {
    private final StudentMarkRepository repository;



    public List<StudentMarkDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(StudentMarkDTO::fromEntity)
                .toList();
    }

    public StudentMarkDTO findById(Integer id) {
        StudentMark entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentMark no encontrada"));
        return StudentMarkDTO.fromEntity(entity);
    }

    public StudentMarkDTO create(StudentMarkDTO dto) {
        StudentMark entity = dto.toEntity();
        return StudentMarkDTO.fromEntity(repository.save(entity));
    }

    public StudentMarkDTO update(Integer id, StudentMarkDTO dto) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentMark no encontrada"));
        StudentMark entity = dto.toEntity();
        entity.setId(id);
        return StudentMarkDTO.fromEntity(repository.save(entity));
    }

    public void delete(Integer id) {
        StudentMark entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentMark no encontrada"));
        repository.delete(entity);
    }
}
