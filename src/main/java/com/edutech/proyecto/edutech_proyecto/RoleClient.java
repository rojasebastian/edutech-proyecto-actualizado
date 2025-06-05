package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.RoleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-role", url = "http://localhost:8080/api/role")
public interface RoleClient {

    @GetMapping
    List<RoleDTO> findAll();

    @GetMapping("/{id}")
    RoleDTO findById(@PathVariable("id") Integer id);

    @PostMapping
    RoleDTO create(@RequestBody RoleDTO dto);

    @PutMapping("/{id}")
    RoleDTO update(@PathVariable("id") Integer id, @RequestBody RoleDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);
}
