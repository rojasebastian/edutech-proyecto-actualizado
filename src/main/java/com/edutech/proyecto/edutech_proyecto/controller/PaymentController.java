package com.edutech.proyecto.edutech_proyecto.controller;

import com.edutech.proyecto.edutech_proyecto.PaymentService;
import com.edutech.proyecto.edutech_proyecto.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @GetMapping
    public List<PaymentDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public PaymentDTO create(@RequestBody PaymentDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public PaymentDTO update(@PathVariable Integer id, @RequestBody PaymentDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
