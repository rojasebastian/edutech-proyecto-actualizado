package com.edutech.proyecto.edutech_proyecto.controller;

import com.edutech.proyecto.edutech_proyecto.CourseQuizService;
import com.edutech.proyecto.edutech_proyecto.dto.CourseQuizDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course-quiz")
@RequiredArgsConstructor
public class CourseQuizController {
    private final CourseQuizService courseQuizService;
    @GetMapping
    public ResponseEntity<List<CourseQuizDTO>> findAll() {
        return ResponseEntity.ok(courseQuizService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseQuizDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseQuizService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseQuizDTO> create(@Valid @RequestBody CourseQuizDTO dto) {
        return ResponseEntity.ok(courseQuizService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseQuizDTO> update(@PathVariable Integer id, @Valid @RequestBody CourseQuizDTO dto) {
        return ResponseEntity.ok(courseQuizService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        courseQuizService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CourseQuizDTO>> findByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.ok(courseQuizService.findByCourseId(courseId));
    }
}
