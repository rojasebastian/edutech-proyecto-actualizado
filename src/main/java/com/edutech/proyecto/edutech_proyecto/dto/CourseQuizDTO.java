package com.edutech.proyecto.edutech_proyecto.dto;


import com.edutech.proyecto.edutech_proyecto.entity.Course;
import com.edutech.proyecto.edutech_proyecto.entity.CourseQuiz;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class CourseQuizDTO {

    private Integer id;
    @NotNull(message = "El curso no puede estar vacio")
    private Integer courseId;
    @NotNull(message = "El titulo no puede estar vacio")
    @Size(max = 200, message = "El título no puede superar los 200 caracteres")
    private String title;
    @NotNull(message = "La descripcion no puede estar vacio")
    @Size(max = 200, message = "La descripcion no puede superar los 200 caracteres")
    private String description;
    @NotNull(message = "El tipo de pregunta no puede estar vacio")
    @Size(max = 100, message = "El tipo de pregunta no puede superar los 100 caracteres")
    private String quizType;
    @NotNull(message = "La fecha no puede estar vacia")
    private Instant createdAt;

    public static CourseQuizDTO fromEntity(CourseQuiz entity) {

        CourseQuizDTO dto = new CourseQuizDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setQuizType(entity.getQuizType());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;

    }
    public static CourseQuiz toEntity(CourseQuizDTO dto) {
        CourseQuiz entity = new CourseQuiz();
        entity.setId(dto.getId());

        Course course = new Course();
        course.setId(dto.getCourseId());
        entity.setCourse(course);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setQuizType(dto.getQuizType());
        entity.setCreatedAt(dto.getCreatedAt());

        return entity;

    }


}
