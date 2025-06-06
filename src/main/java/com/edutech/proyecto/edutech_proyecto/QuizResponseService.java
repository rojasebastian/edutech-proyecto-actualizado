package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.QuizResponseDTO;
import com.edutech.proyecto.edutech_proyecto.entity.QuizResponse;

import com.edutech.proyecto.edutech_proyecto.repository.QuizResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizResponseService {
    private final QuizResponseRepository repository;

    public List<QuizResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(QuizResponseDTO::fromEntity)
                .toList();
    }

    public QuizResponseDTO findById(Integer id) {
        QuizResponse response = repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Respuesta no encontrada"));
        return QuizResponseDTO.fromEntity(response);
    }

    public List<QuizResponseDTO> findByQuizId(Integer quizId) {
        return repository.findByQuizId(quizId).stream()
                .map(QuizResponseDTO::fromEntity)
                .toList();
    }

    public List<QuizResponseDTO> findByStudentId(Integer studentId) {
        return repository.findByStudentId(studentId).stream()
                .map(QuizResponseDTO::fromEntity)
                .toList();
    }

    public List<QuizResponseDTO> findByQuizIdAndStudentId(Integer quizId, Integer studentId) {
        return repository.findByQuizIdAndStudentId(quizId, studentId).stream()
                .map(QuizResponseDTO::fromEntity)
                .toList();
    }

    public QuizResponseDTO create(QuizResponseDTO dto) {
        QuizResponse entity = QuizResponseDTO.toEntity(dto);
        return QuizResponseDTO.fromEntity(repository.save(entity));
    }

    public QuizResponseDTO update(Integer id, QuizResponseDTO dto) {
        repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Respuesta no encontrada"));
        QuizResponse entity = QuizResponseDTO.toEntity(dto);
        entity.setId(id);
        return QuizResponseDTO.fromEntity(repository.save(entity));
    }

    public void delete(Integer id) {
        QuizResponse entity = repository.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Respuesta no encontrada"));
        repository.delete(entity);
    }
}
