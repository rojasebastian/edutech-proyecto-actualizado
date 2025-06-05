package com.edutech.proyecto.edutech_proyecto.controller;


import com.edutech.proyecto.edutech_proyecto.DiscountCouponService;
import com.edutech.proyecto.edutech_proyecto.dto.DiscountCouponDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/discount-coupon")
@RequiredArgsConstructor
public class DiscountCouponController {
    private final DiscountCouponService service;

    @GetMapping
    public ResponseEntity<List<DiscountCouponDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<DiscountCouponDTO> getByCode(@PathVariable String code) {
        return service.findByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DiscountCouponDTO> create(@Valid @RequestBody DiscountCouponDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> update(@PathVariable Integer id, @Valid @RequestBody DiscountCouponDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
