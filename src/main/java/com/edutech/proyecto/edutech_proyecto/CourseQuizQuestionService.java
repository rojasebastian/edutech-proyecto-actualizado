package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.CourseQuizQuestionDTO;
import com.edutech.proyecto.edutech_proyecto.entity.CourseQuizQuestion;
import com.edutech.proyecto.edutech_proyecto.repository.CourseQuizQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseQuizQuestionService {
    private final CourseQuizQuestionRepository repo;

    public List<CourseQuizQuestionDTO> findAll() {
        return repo.findAll().stream()
                .map(CourseQuizQuestionDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CourseQuizQuestionDTO> findByQuizId(Integer quizId) {
        return repo.findByQuizId(quizId).stream()
                .map(CourseQuizQuestionDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public CourseQuizQuestionDTO findById(Integer id) {
        return repo.findById(id)
                .map(CourseQuizQuestionDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
    }

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        CourseQuizQuestion entity = CourseQuizQuestionDTO.toEntity(dto);
        return CourseQuizQuestionDTO.fromEntity(repo.save(entity));
    }

    public CourseQuizQuestionDTO update(Integer id, CourseQuizQuestionDTO dto) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Pregunta no encontrada");
        }
        CourseQuizQuestion entity = CourseQuizQuestionDTO.toEntity(dto);
        entity.setId(id);
        return CourseQuizQuestionDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
