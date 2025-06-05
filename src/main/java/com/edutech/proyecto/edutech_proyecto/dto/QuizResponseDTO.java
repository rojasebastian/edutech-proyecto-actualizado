package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.CourseQuiz;
import com.edutech.proyecto.edutech_proyecto.entity.QuizResponse;
import com.edutech.proyecto.edutech_proyecto.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
public class QuizResponseDTO {

    private Integer id;
    @NotNull(message = "El cuestionario no puede estar vacío")
    private Integer quizId;
    @NotNull(message = "El estudiante no puede estar vacío")
    private Integer studentId;
    @Size(max = 1, message = "La opción seleccionada debe ser una sola letra")
    private String selectedOption;
    @NotNull(message = "La respuesta no puede estar vacía")
    @Size(max = 800, message = "La respuesta no puede superar los 800 caracteres")
    private String responseContent;
    @NotNull(message = "La url no puede estar vacía")
    @Size(max = 800, message = "La URL de la tarea no puede superar los 800 caracteres")
    private String assignmentUrl;
    @NotNull(message = "La fecha de envío no puede estar vacía")
    private Instant submittedAt;

    public static QuizResponseDTO fromEntity(QuizResponse qr) {
        QuizResponseDTO dto = new QuizResponseDTO();
        dto.setId(qr.getId());
        dto.setQuizId(qr.getQuiz().getId());
        dto.setStudentId(qr.getStudent().getId());
        dto.setSelectedOption(qr.getSelectedOption());
        dto.setResponseContent(qr.getResponseContent());
        dto.setAssignmentUrl(qr.getAssignmentUrl());
        dto.setSubmittedAt(qr.getSubmittedAt());
        return dto;
    }

    public static QuizResponse toEntity(QuizResponseDTO dto) {
        QuizResponse qr = new QuizResponse();
        CourseQuiz quiz = new CourseQuiz();
        quiz.setId(dto.getQuizId());
        qr.setQuiz(quiz);
        User student = new User();
        student.setId(dto.getStudentId());
        qr.setStudent(student);
        qr.setSelectedOption(dto.getSelectedOption());
        qr.setResponseContent(dto.getResponseContent());
        qr.setAssignmentUrl(dto.getAssignmentUrl());
        qr.setSubmittedAt(dto.getSubmittedAt());
        return qr;
    }
}
