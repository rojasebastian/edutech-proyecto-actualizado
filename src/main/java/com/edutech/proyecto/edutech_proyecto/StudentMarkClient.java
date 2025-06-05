package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.StudentMarkDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-student-mark", url = "http://localhost:8080/api/student-mark")
public interface StudentMarkClient {


    @GetMapping
    List<StudentMarkDTO> findAll();

    @GetMapping("/{id}")
    StudentMarkDTO findById(@PathVariable("id") Integer id);

    @PostMapping
    StudentMarkDTO create(@RequestBody StudentMarkDTO dto);

    @PutMapping("/{id}")
    StudentMarkDTO update(@PathVariable("id") Integer id, @RequestBody StudentMarkDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);
}
