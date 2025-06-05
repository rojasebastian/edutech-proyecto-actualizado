package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-payment", url = "http://localhost:8080/api/payment")
public interface PaymentClient {

    @GetMapping
    List<PaymentDTO> findAll();

    @GetMapping("/{id}")
    PaymentDTO findById(@PathVariable("id") Integer id);

    @PostMapping
    PaymentDTO create(@RequestBody PaymentDTO dto);

    @PutMapping("/{id}")
    PaymentDTO update(@PathVariable("id") Integer id, @RequestBody PaymentDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);
}
