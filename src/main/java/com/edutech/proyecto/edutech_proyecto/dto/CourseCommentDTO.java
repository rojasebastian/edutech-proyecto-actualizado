package com.edutech.proyecto.edutech_proyecto.dto;


import com.edutech.proyecto.edutech_proyecto.entity.CourseComment;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseCommentDTO {


    private Integer id;
    @NotNull(message = "El curso no puede estar vacio")

    private Integer courseId;
    @NotNull(message = "El usuario no puede estar vacio")

    private Integer userId;
    @NotNull(message = "El comentario no puede estar vacio")
    @Size(max = 100, message = "El comentario no puede superar los 100 caracteres")
    private String commentText;
    @NotNull(message = "El rating no puede estar vacio")
    @Min(value = 1, message = "El rating debe ser al menos 1")
    private Integer rating;
    @NotNull(message = "La fecha no puede estar vacia")

    private Instant createdAt;


    public static CourseCommentDTO fromEntity(CourseComment entity) {
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourseId());
        dto.setUserId(entity.getUserId());
        dto.setCommentText(entity.getCommentText());
        dto.setRating(entity.getRating());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;

    }
    public static CourseComment toEntity(CourseCommentDTO dto) {
        CourseComment entity = new CourseComment();
        entity.setId(dto.getId());
        entity.setCourseId(dto.getCourseId());
        entity.setUserId(dto.getUserId());
        entity.setCommentText(dto.getCommentText());
        entity.setRating(dto.getRating());
        entity.setCreatedAt(dto.getCreatedAt());

        return entity;

    }
}
