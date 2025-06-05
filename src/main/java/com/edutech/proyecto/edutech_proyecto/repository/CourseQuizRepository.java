package com.edutech.proyecto.edutech_proyecto.repository;

import com.edutech.proyecto.edutech_proyecto.entity.Course;
import com.edutech.proyecto.edutech_proyecto.entity.CourseQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseQuizRepository extends JpaRepository<CourseQuiz, Integer> {

    List<CourseQuiz> findByCourseId(Integer courseId);
    List<CourseQuiz> findByQuizType(String quizType);
}
