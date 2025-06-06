package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.CourseQuizQuestionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-course-quizquestion", url = "http://localhost:3306/api/course-quizquestion")
public interface CourseQuizQuestionClient {

    @GetMapping
    List<CourseQuizQuestionDTO> getAll();

    @GetMapping("/quiz/{quizId}")
    List<CourseQuizQuestionDTO> getByQuizId(@PathVariable("quizId") Integer quizId);

    @GetMapping("/{id}")
    CourseQuizQuestionDTO getById(@PathVariable("id") Integer id);

    @PostMapping
    CourseQuizQuestionDTO create(@RequestBody CourseQuizQuestionDTO dto);

    @PutMapping("/{id}")
    CourseQuizQuestionDTO update(@PathVariable("id") Integer id, @RequestBody CourseQuizQuestionDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);

}
