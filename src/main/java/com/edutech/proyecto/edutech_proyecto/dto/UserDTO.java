package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.Role;
import com.edutech.proyecto.edutech_proyecto.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class UserDTO {

    private Integer id;

    @NotNull(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String firstName;

    @NotNull(message = "El apellido no puede estar vacío")
    @Size(max = 100, message = "El apellido no puede superar los 100 caracteres")
    private String lastName;

    @NotNull(message = "El email no puede estar vacío")
    @Size(max = 255, message = "El email no puede superar los 255 caracteres")
    private String email;

    @NotNull(message = "La contraseña no puede estar vacía")
    @Size(max = 255, message = "La contraseña no puede superar los 255 caracteres")
    private String passwordHash;

    @NotNull(message = "El rol es obligatorio")
    private Integer roleId;

    private Boolean isActive = false;

    private Instant createdAt;

    private Instant updatedAt;

    public static UserDTO fromEntity(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPasswordHash(entity.getPasswordHash());
        dto.setRoleId(entity.getRole() != null ? entity.getRole().getId() : null);
        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public User toEntity() {
        User entity = new User();
        entity.setId(this.getId());
        entity.setFirstName(this.getFirstName());
        entity.setLastName(this.getLastName());
        entity.setEmail(this.getEmail());
        entity.setPasswordHash(this.getPasswordHash());

        if (this.getRoleId() != null) {
            Role role = new Role();
            role.setId(this.getRoleId());
            entity.setRole(role);
        } else {
            entity.setRole(null);
        }

        entity.setIsActive(this.getIsActive());
        entity.setCreatedAt(this.getCreatedAt());
        entity.setUpdatedAt(this.getUpdatedAt());
        return entity;
    }
}
