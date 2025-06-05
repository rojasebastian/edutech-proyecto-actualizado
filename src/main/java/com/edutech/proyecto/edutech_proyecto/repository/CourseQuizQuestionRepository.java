package com.edutech.proyecto.edutech_proyecto.repository;

import com.edutech.proyecto.edutech_proyecto.entity.CourseQuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseQuizQuestionRepository extends JpaRepository<CourseQuizQuestion, Integer> {

    List<CourseQuizQuestion> findByQuizId(Integer quizId);


}
