package com.edutech.proyecto.edutech_proyecto.controller;


import com.edutech.proyecto.edutech_proyecto.SupportTicketService;
import com.edutech.proyecto.edutech_proyecto.dto.SupportTicketDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/support-ticket")
@RequiredArgsConstructor
public class SupportTicketController {
    private final SupportTicketService service;


    @GetMapping
    public ResponseEntity<List<SupportTicketDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicketDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<SupportTicketDTO> create(@RequestBody @Valid SupportTicketDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportTicketDTO> update(@PathVariable Integer id, @Valid @RequestBody SupportTicketDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
