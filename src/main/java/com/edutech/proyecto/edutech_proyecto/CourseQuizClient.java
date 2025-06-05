package com.edutech.proyecto.edutech_proyecto;

import com.edutech.proyecto.edutech_proyecto.dto.CourseQuizDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-course-quiz", url = "http://localhost:8080/api/course-quiz")
public interface CourseQuizClient {

    @GetMapping
    List<CourseQuizDTO> getAll();

    @GetMapping("/{id}")
    CourseQuizDTO getById(@PathVariable("id") Integer id);

    @PostMapping
    CourseQuizDTO create(@RequestBody CourseQuizDTO dto);

    @PutMapping("/{id}")
    CourseQuizDTO update(@PathVariable("id") Integer id, @RequestBody CourseQuizDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);

    @GetMapping("/course/{courseId}")
    List<CourseQuizDTO> getByCourseId(@PathVariable("courseId") Integer courseId);

}
