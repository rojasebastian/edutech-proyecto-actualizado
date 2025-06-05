package com.edutech.proyecto.edutech_proyecto.controller;

import com.edutech.proyecto.edutech_proyecto.CourseCommentService;
import com.edutech.proyecto.edutech_proyecto.dto.CourseCommentDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course-commentaries")
@RequiredArgsConstructor
public class CourseCommentController {
    private final CourseCommentService service;

    @GetMapping
    public ResponseEntity<List<CourseCommentDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseCommentDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/by-course/{courseId}")
    public ResponseEntity<List<CourseCommentDTO>> findByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.ok(service.findByCourseId(courseId));
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<CourseCommentDTO>> findByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.findByUserId(userId));
    }

    @GetMapping("/by-course-user")
    public ResponseEntity<List<CourseCommentDTO>> findByCourseIdAndUserId(
            @RequestParam Integer courseId,
            @RequestParam Integer userId
    ) {
        return ResponseEntity.ok(service.findByCourseIdAndUserId(courseId, userId));
    }

    @PostMapping
    public ResponseEntity<CourseCommentDTO> create(@Valid @RequestBody CourseCommentDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseCommentDTO> update(@PathVariable Integer id, @Valid @RequestBody CourseCommentDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
