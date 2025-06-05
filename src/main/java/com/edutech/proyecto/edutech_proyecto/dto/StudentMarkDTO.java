package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.CourseQuiz;
import com.edutech.proyecto.edutech_proyecto.entity.StudentMark;
import com.edutech.proyecto.edutech_proyecto.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class StudentMarkDTO {

    private Integer id;

    @NotNull(message = "El id del quiz es obligatorio")
    private Integer quizId;

    @NotNull(message = "El id del estudiante es obligatorio")
    private Integer studentId;

    @NotNull(message = "La nota es obligatoria")
    private BigDecimal mark;


    @Size(max = 800, message = "Los comentarios no pueden exceder los 800 caracteres")
    private String comments;

    @NotNull(message = "La fecha de calificación es obligatoria")
    private Instant gradedAt;







    public static StudentMarkDTO fromEntity(StudentMark entity) {
        StudentMarkDTO dto = new StudentMarkDTO();
        dto.setId(entity.getId());
        dto.setQuizId(entity.getQuiz() != null ? entity.getQuiz().getId() : null);
        dto.setStudentId(entity.getStudent() != null ? entity.getStudent().getId() : null);
        dto.setMark(entity.getMark());
        dto.setComments(entity.getComments());
        dto.setGradedAt(entity.getGradedAt());
        return dto;
    }

    public StudentMark toEntity() {
        StudentMark entity = new StudentMark();
        entity.setId(this.id);
        if (this.quizId != null) {
            CourseQuiz quiz = new CourseQuiz();
            quiz.setId(this.quizId);
            entity.setQuiz(quiz);
        }
        if (this.studentId != null) {
            User student = new User();
            student.setId(this.studentId);
            entity.setStudent(student);
        }
        entity.setMark(this.mark);
        entity.setComments(this.comments);
        entity.setGradedAt(this.gradedAt);
        return entity;
    }
}
