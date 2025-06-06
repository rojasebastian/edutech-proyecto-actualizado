package com.edutech.proyecto.edutech_proyecto;


import com.edutech.proyecto.edutech_proyecto.dto.CourseContentDTO;
import com.edutech.proyecto.edutech_proyecto.entity.CourseContent;

import com.edutech.proyecto.edutech_proyecto.repository.CourseContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseContentService {
    private final CourseContentRepository repo;

    public List<CourseContentDTO> findAll() {
        return repo.findAll().stream()
                .map(CourseContentDTO::fromEntity)
                .toList();
    }

    public CourseContentDTO findById(Integer id) {
        CourseContent content = repo.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Contenido no encontrado"));
        return CourseContentDTO.fromEntity(content);
    }

    public List<CourseContentDTO> findByCourseId(Integer courseId) {
        return repo.findByCourseId(courseId).stream()
                .map(CourseContentDTO::fromEntity)
                .toList();
    }

    public CourseContentDTO create(CourseContentDTO dto) {
        CourseContent content = CourseContentDTO.toEntity(dto);
        return CourseContentDTO.fromEntity(repo.save(content));
    }

    public CourseContentDTO update(Integer id, CourseContentDTO dto) {
        repo.findById(id).orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Contenido no encontrado"));
        CourseContent content = CourseContentDTO.toEntity(dto);
        content.setId(id);
        return CourseContentDTO.fromEntity(repo.save(content));
    }

    public void delete(Integer id) {
        CourseContent content = repo.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Contenido no encontrado"));
        repo.delete(content);
    }
}
