package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.QuizResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-quiz-response", url = "http://localhost:8080/api/quiz-response")
public interface QuizResponseClient {

    @GetMapping
    List<QuizResponseDTO> findAll();

    @GetMapping("/{id}")
    QuizResponseDTO findById(@PathVariable("id") Integer id);

    @GetMapping("/by-quiz/{quizId}")
    List<QuizResponseDTO> findByQuizId(@PathVariable("quizId") Integer quizId);

    @GetMapping("/by-student/{studentId}")
    List<QuizResponseDTO> findByStudentId(@PathVariable("studentId") Integer studentId);

    @GetMapping("/by-quiz-and-student")
    List<QuizResponseDTO> findByQuizIdAndStudentId(@RequestParam("quizId") Integer quizId,
                                                   @RequestParam("studentId") Integer studentId);

    @PostMapping
    QuizResponseDTO create(@RequestBody QuizResponseDTO dto);

    @PutMapping("/{id}")
    QuizResponseDTO update(@PathVariable("id") Integer id, @RequestBody QuizResponseDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);
}
