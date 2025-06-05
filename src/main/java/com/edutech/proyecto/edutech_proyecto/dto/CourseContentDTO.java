package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.Course;
import com.edutech.proyecto.edutech_proyecto.entity.CourseContent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseContentDTO {

    private Integer id;
    @NotNull(message = "El curso no puede estar vacio")
    private Integer courseId;
    @NotNull(message = "El titulo no puede estar vacio")
    @Size(max = 200, message = "El título no puede superar los 200 caracteres")
    private String title;
    @NotNull(message = "El tipo de contenido no puede estar vacio")
    @Size(max = 100, message = "El tipo de contenido no puede superar los 100 caracteres")
    private String contentType;
    @NotNull(message = "La url no puede estar vacio")
    @Size(max = 800, message = "La URL no puede superar los 800 caracteres")
    private String url;
    @NotNull(message = "El índice de orden no puede estar vacío")
    private Integer orderIndex;


    public static CourseContentDTO fromEntity(CourseContent entity) {
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setTitle(entity.getTitle());
        dto.setContentType(entity.getContentType());
        dto.setUrl(entity.getUrl());
        dto.setOrderIndex(entity.getOrderIndex());
        return dto;
    }

    public static CourseContent toEntity(CourseContentDTO dto) {
        CourseContent entity = new CourseContent();
        entity.setId(dto.getId());

        Course course = new Course();
        course.setId(dto.getCourseId());
        entity.setCourse(course);
        entity.setTitle(dto.getTitle());
        entity.setContentType(dto.getContentType());
        entity.setUrl(dto.getUrl());
        entity.setOrderIndex(dto.getOrderIndex());
        return entity;
    }
}
