package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.EnrollmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-enrollment", url = "http://localhost:3306/api/enrollment")
public interface EnrollmentClient {


    @GetMapping
    List<EnrollmentDTO> getAll();

    @GetMapping("/{id}")
    EnrollmentDTO getById(@PathVariable("id") Integer id);

    @PostMapping
    EnrollmentDTO create(@RequestBody EnrollmentDTO dto);

    @PutMapping("/{id}")
    EnrollmentDTO update(@PathVariable("id") Integer id, @RequestBody EnrollmentDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);
}
