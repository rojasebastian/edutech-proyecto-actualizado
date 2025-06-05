package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleDTO {

    private Integer id;
    @NotNull(message = "El nombre no puede estar vacio")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String name;
    @NotNull(message = "La descripcion no puede estar vacia")
    @Size(max = 800, message = "La descripción no puede superar los 800 caracteres")
    private String description;

    public static RoleDTO fromEntity(Role entity) {
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;

    }
    public static Role toEntity(RoleDTO dto) {
        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

}
