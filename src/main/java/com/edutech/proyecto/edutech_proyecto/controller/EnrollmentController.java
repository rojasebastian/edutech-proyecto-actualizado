package com.edutech.proyecto.edutech_proyecto.controller;

import com.edutech.proyecto.edutech_proyecto.EnrollmentService;
import com.edutech.proyecto.edutech_proyecto.dto.EnrollmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {


    private final EnrollmentService service;

    @GetMapping
    public List<EnrollmentDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> getById(@PathVariable Integer id) {
        EnrollmentDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@RequestBody EnrollmentDTO dto) {
        EnrollmentDTO created = service.create(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable Integer id, @RequestBody EnrollmentDTO dto) {
        EnrollmentDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
