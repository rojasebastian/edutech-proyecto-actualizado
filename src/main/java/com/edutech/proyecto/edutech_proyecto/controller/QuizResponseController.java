package com.edutech.proyecto.edutech_proyecto.controller;


import com.edutech.proyecto.edutech_proyecto.QuizResponseService;
import com.edutech.proyecto.edutech_proyecto.dto.QuizResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quiz-response")
@RequiredArgsConstructor
public class QuizResponseController {
    private final QuizResponseService service;


    @GetMapping
    public List<QuizResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public QuizResponseDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/by-quiz/{quizId}")
    public List<QuizResponseDTO> findByQuizId(@PathVariable Integer quizId) {
        return service.findByQuizId(quizId);
    }

    @GetMapping("/by-student/{studentId}")
    public List<QuizResponseDTO> findByStudentId(@PathVariable Integer studentId) {
        return service.findByStudentId(studentId);
    }

    @GetMapping("/by-quiz-and-student")
    public List<QuizResponseDTO> findByQuizIdAndStudentId(
            @RequestParam Integer quizId,
            @RequestParam Integer studentId) {
        return service.findByQuizIdAndStudentId(quizId, studentId);
    }

    @PostMapping
    public QuizResponseDTO create(@Valid @RequestBody QuizResponseDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public QuizResponseDTO update(@PathVariable Integer id, @Valid @RequestBody QuizResponseDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
