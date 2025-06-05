package com.edutech.proyecto.edutech_proyecto.repository;

import com.edutech.proyecto.edutech_proyecto.entity.QuizResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizResponseRepository extends JpaRepository<QuizResponse, Integer> {


    List<QuizResponse> findByQuizId(Integer quizId);

    List<QuizResponse> findByStudentId(Integer studentId);

    List<QuizResponse> findByQuizIdAndStudentId(Integer quizId, Integer studentId);
}
