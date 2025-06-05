package com.edutech.proyecto.edutech_proyecto;


import com.edutech.proyecto.edutech_proyecto.dto.CourseContentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-course-content", url = "http://localhost:3306/api/course-content")
public interface CourseContentClient {

    @GetMapping
    List<CourseContentDTO> getAll();

    @GetMapping("/{id}")
    CourseContentDTO getById(@PathVariable("id") Integer id);

    @GetMapping("/course/{courseId}")
    List<CourseContentDTO> getByCourseId(@PathVariable("courseId") Integer courseId);

    @PostMapping
    CourseContentDTO create(@RequestBody CourseContentDTO dto);

    @PutMapping("/{id}")
    CourseContentDTO update(@PathVariable("id") Integer id, @RequestBody CourseContentDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);


}
