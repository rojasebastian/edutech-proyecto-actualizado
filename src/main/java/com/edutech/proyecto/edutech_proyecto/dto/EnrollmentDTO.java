package com.edutech.proyecto.edutech_proyecto.dto;

import com.edutech.proyecto.edutech_proyecto.entity.Course;
import com.edutech.proyecto.edutech_proyecto.entity.Enrollment;
import com.edutech.proyecto.edutech_proyecto.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class EnrollmentDTO {

    private Integer id;
    @NotNull(message = "El ID del estudiante no puede estar vacío")
    private Integer studentId;
    @NotNull(message = "El ID del curso no puede estar vacío")
    private Integer courseId;
    @NotNull(message = "La fecha de inscripción no puede estar vacía")
    private Instant enrolledAt;
    @NotNull(message = "El estado no puede estar vacío")
    @Size(max = 100, message = "El estado no puede superar los 100 caracteres")
    private String status;


    public static EnrollmentDTO fromEntity(Enrollment entity) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(entity.getId());
        dto.setStudentId(entity.getStudent().getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setEnrolledAt(entity.getEnrolledAt());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static Enrollment toEntity(EnrollmentDTO dto) {
        Enrollment entity = new Enrollment();
        entity.setId(dto.getId());

        User student = new User();
        student.setId(dto.getStudentId());
        entity.setStudent(student);

        Course course = new Course();
        course.setId(dto.getCourseId());
        entity.setCourse(course);
        entity.setEnrolledAt(dto.getEnrolledAt());
        entity.setStatus(dto.getStatus());
        return entity;
    }

}
