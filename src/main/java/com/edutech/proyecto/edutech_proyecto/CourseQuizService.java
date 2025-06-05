package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.CourseQuizDTO;
import com.edutech.proyecto.edutech_proyecto.entity.CourseQuiz;
import com.edutech.proyecto.edutech_proyecto.exception.ResourceNotFoundException;
import com.edutech.proyecto.edutech_proyecto.repository.CourseQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQuizService {
    private final CourseQuizRepository repo;

    public List<CourseQuizDTO> findAll() {
        return repo.findAll().stream().map(CourseQuizDTO::fromEntity).toList();
    }

    public CourseQuizDTO findById(Integer id) {
        CourseQuiz quiz = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));
        return CourseQuizDTO.fromEntity(quiz);
    }

    public CourseQuizDTO create(CourseQuizDTO dto) {
        return CourseQuizDTO.fromEntity(repo.save(CourseQuizDTO.toEntity(dto)));
    }

    public CourseQuizDTO update(Integer id, CourseQuizDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));
        CourseQuiz entity = CourseQuizDTO.toEntity(dto);
        entity.setId(id);
        return CourseQuizDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        CourseQuiz quiz = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));
        repo.delete(quiz);
    }


    public List<CourseQuizDTO> findByCourseId(Integer courseId) {
        return repo.findByCourseId(courseId)
                .stream()
                .map(CourseQuizDTO::fromEntity)
                .toList();
    }

}
