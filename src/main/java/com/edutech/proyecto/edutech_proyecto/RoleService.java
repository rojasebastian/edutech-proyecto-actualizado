package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.RoleDTO;
import com.edutech.proyecto.edutech_proyecto.entity.Role;

import com.edutech.proyecto.edutech_proyecto.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repo;


    public List<RoleDTO> findAll() {
        return repo.findAll().stream().map(RoleDTO::fromEntity).toList();
    }

    public RoleDTO findById(Integer id) {
        Role role = repo.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Rol no encontrado con ID: " + id));
        return RoleDTO.fromEntity(role);
    }

    public RoleDTO create(RoleDTO dto) {
        return RoleDTO.fromEntity(repo.save(RoleDTO.toEntity(dto)));
    }

    public RoleDTO update(Integer id, RoleDTO dto) {
        repo.findById(id).orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Rol no encontrado con ID: " + id));
        Role role = RoleDTO.toEntity(dto);
        role.setId(id);
        return RoleDTO.fromEntity(repo.save(role));
    }

    public void delete(Integer id) {
        Role role = repo.findById(id)
                .orElseThrow(() -> new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Rol no encontrado con ID: " + id));
        repo.delete(role);
    }

    public RoleDTO findByName(String name) {
        Role role = repo.findByName(name);
        if (role == null) {
            throw new com.edutech.microservice.course_category.exception.ResourceNotFoundException("Rol no encontrado con nombre: " + name);
        }
        return RoleDTO.fromEntity(role);
    }
}
