package com.edutech.proyecto.edutech_proyecto;


import com.edutech.proyecto.edutech_proyecto.dto.CourseCommentDTO;
import com.edutech.proyecto.edutech_proyecto.entity.CourseComment;
import com.edutech.proyecto.edutech_proyecto.exception.ResourceNotFoundException;
import com.edutech.proyecto.edutech_proyecto.repository.CourseCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCommentService {


    private final CourseCommentRepository repo;

    public List<CourseCommentDTO> findAll() {
        return repo.findAll().stream().map(CourseCommentDTO::fromEntity).toList();
    }

    public CourseCommentDTO findById(Integer id) {
        return CourseCommentDTO.fromEntity(
                repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"))
        );
    }

    public List<CourseCommentDTO> findByCourseId(Integer courseId) {
        return repo.findByCourseId(courseId).stream().map(CourseCommentDTO::fromEntity).toList();
    }

    public List<CourseCommentDTO> findByUserId(Integer userId) {
        return repo.findByUserId(userId).stream().map(CourseCommentDTO::fromEntity).toList();
    }

    public List<CourseCommentDTO> findByCourseIdAndUserId(Integer courseId, Integer userId) {
        return repo.findByCourseIdAndUserId(courseId, userId)
                .stream().map(CourseCommentDTO::fromEntity).toList();
    }

    public CourseCommentDTO create(CourseCommentDTO dto) {
        return CourseCommentDTO.fromEntity(repo.save(CourseCommentDTO.toEntity(dto)));
    }

    public CourseCommentDTO update(Integer id, CourseCommentDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        CourseComment entity = CourseCommentDTO.toEntity(dto);
        entity.setId(id);
        return CourseCommentDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        CourseComment entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        repo.delete(entity);
    }
}
