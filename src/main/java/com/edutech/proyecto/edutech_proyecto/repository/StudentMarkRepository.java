package com.edutech.proyecto.edutech_proyecto.repository;


import com.edutech.proyecto.edutech_proyecto.entity.StudentMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentMarkRepository extends JpaRepository<StudentMark, Integer> {

    List<StudentMark> findByStudentId(Integer studentId);

    List<StudentMark> findByQuizId(Integer quizId);

    Optional<StudentMark> findByQuizIdAndStudentId(Integer quizId, Integer studentId);

}
