package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.CourseQuiz;
import com.edutech.proyecto.edutech_proyecto.entity.CourseQuizQuestion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseQuizQuestionDTO {

    private Integer id;

    @NotNull(message = "El quiz no puede estar vacío")
    private Integer quizId;
    @NotNull(message = "La pregunta no puede estar vacía")
    @Size(max = 800, message = "La pregunta no puede superar los 800 caracteres")
    private String questionText;
    @NotNull(message = "La opcion no puede estar vacía")
    @Size(max = 800)
    private String optionA;

    @NotNull(message = "La opcion no puede estar vacía")
    @Size(max = 800)
    private String optionB;

    @NotNull(message = "La opcion no puede estar vacía")
    @Size(max = 800)
    private String optionC;

    @NotNull(message = "La opcion no puede estar vacía")
    @Size(max = 800)
    private String optionD;

    @NotNull(message = "La opcion no puede estar vacía")
    @Size(max = 800)
    private String optionE;

    @NotNull(message = "La opcion no puede estar vacía")
    @Size(max = 800)
    private String correctAnswer;

    @NotNull(message = "La opcion no puede estar vacía")
    @Size(max = 1)
    private String correctOption;

    @NotNull(message = "El índice de orden no puede estar vacío")
    private Integer orderIndex;

    @NotNull(message = "La fecha no puede estar vacia")
    private Instant createdAt;

    public static CourseQuizQuestionDTO fromEntity(CourseQuizQuestion entity) {
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(entity.getId());
        dto.setQuizId(entity.getQuiz() != null ? entity.getQuiz().getId() : null);
        dto.setQuestionText(entity.getQuestionText());
        dto.setOptionA(entity.getOptionA());
        dto.setOptionB(entity.getOptionB());
        dto.setOptionC(entity.getOptionC());
        dto.setOptionD(entity.getOptionD());
        dto.setOptionE(entity.getOptionE());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        dto.setCorrectOption(entity.getCorrectOption());
        dto.setOrderIndex(entity.getOrderIndex());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static CourseQuizQuestion toEntity(CourseQuizQuestionDTO dto) {

        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(dto.getId());
        if (dto.getQuizId() != null) {
            var quiz = new CourseQuiz();
            quiz.setId(dto.getQuizId());
            entity.setQuiz(quiz);
        }

        entity.setQuestionText(dto.getQuestionText());
        entity.setOptionA(dto.getOptionA());
        entity.setOptionB(dto.getOptionB());
        entity.setOptionC(dto.getOptionC());
        entity.setOptionD(dto.getOptionD());
        entity.setOptionE(dto.getOptionE());
        entity.setCorrectAnswer(dto.getCorrectAnswer());
        entity.setCorrectOption(dto.getCorrectOption());
        entity.setOrderIndex(dto.getOrderIndex());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;

    }
}
