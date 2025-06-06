package com.edutech.proyecto.edutech_proyecto;


import com.edutech.proyecto.edutech_proyecto.dto.EnrollmentDTO;
import com.edutech.proyecto.edutech_proyecto.entity.Course;
import com.edutech.proyecto.edutech_proyecto.entity.Enrollment;
import com.edutech.proyecto.edutech_proyecto.entity.User;

import com.edutech.proyecto.edutech_proyecto.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.edutech.proyecto.edutech_proyecto.dto.EnrollmentDTO.fromEntity;
import static com.edutech.proyecto.edutech_proyecto.dto.EnrollmentDTO.toEntity;

@Service
@RequiredArgsConstructor
public class EnrollmentService {


    private final EnrollmentRepository repo;

    public List<EnrollmentDTO> findAll() {
        return repo.findAll().stream()
                .map(EnrollmentDTO::fromEntity)
                .toList();
    }

    public EnrollmentDTO findById(Integer id) {
        Enrollment enrollment = repo.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Matrícula no encontrada"));
        return fromEntity(enrollment);
    }

    public EnrollmentDTO create(EnrollmentDTO dto) {
        Enrollment enrollment = toEntity(dto);
        return fromEntity(repo.save(enrollment));
    }

    public EnrollmentDTO update(Integer id, EnrollmentDTO dto) {
        repo.findById(id).orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Matrícula no encontrada"));
        Enrollment enrollment = toEntity(dto);
        enrollment.setId(id);
        return fromEntity(repo.save(enrollment));
    }

    public void delete(Integer id) {
        Enrollment enrollment = repo.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Matrícula no encontrada"));
        repo.delete(enrollment);
    }


}
