package com.edutech.proyecto.edutech_proyecto.controller;


import com.edutech.proyecto.edutech_proyecto.StudentMarkService;
import com.edutech.proyecto.edutech_proyecto.dto.StudentMarkDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student-mark")
@RequiredArgsConstructor
public class StudentMarkController {
    private final StudentMarkService service;

    @GetMapping
    public ResponseEntity<List<StudentMarkDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentMarkDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<StudentMarkDTO> create(@RequestBody @Valid StudentMarkDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentMarkDTO> update(@PathVariable Integer id, @Valid @RequestBody StudentMarkDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
