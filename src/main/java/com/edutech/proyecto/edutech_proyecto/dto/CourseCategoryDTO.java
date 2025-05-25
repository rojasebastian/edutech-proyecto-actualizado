package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.CourseCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseCategoryDTO {

    private Integer id;
    @NotNull(message = "El nombre no puede estar vacio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String name;
    @NotNull(message = "La descripcion no puede estar vacio")
    @Size(max = 100, message = "La descripcion no puede superar los 100 caracteres")
    private String description;

    public static CourseCategoryDTO fromEntity(CourseCategory entity) {
        CourseCategoryDTO dto = new CourseCategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
    public CourseCategory toEntity() {
        CourseCategory entity = new CourseCategory();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDescription(this.getDescription());
        return entity;
    }
}
