package com.edutech.proyecto.edutech_proyecto.controller;

import com.edutech.proyecto.edutech_proyecto.CourseQuizQuestionService;
import com.edutech.proyecto.edutech_proyecto.dto.CourseQuizQuestionDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course-quizquestion")
@RequiredArgsConstructor
public class CourseQuizQuestionController {

    private final CourseQuizQuestionService service;

    @GetMapping
    public ResponseEntity<List<CourseQuizQuestionDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<CourseQuizQuestionDTO>> findByQuizId(@PathVariable Integer quizId) {
        return ResponseEntity.ok(service.findByQuizId(quizId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseQuizQuestionDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseQuizQuestionDTO> create(@RequestBody @Valid CourseQuizQuestionDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseQuizQuestionDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseQuizQuestionDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
