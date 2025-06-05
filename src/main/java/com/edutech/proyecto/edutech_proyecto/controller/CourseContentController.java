package com.edutech.proyecto.edutech_proyecto.controller;


import com.edutech.proyecto.edutech_proyecto.CourseContentService;
import com.edutech.proyecto.edutech_proyecto.dto.CourseContentDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course-content")
@RequiredArgsConstructor
public class CourseContentController {

    private final CourseContentService service;

    @GetMapping
    public ResponseEntity<List<CourseContentDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseContentDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CourseContentDTO>> findByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.ok(service.findByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<CourseContentDTO> create(@RequestBody @Valid CourseContentDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseContentDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseContentDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
