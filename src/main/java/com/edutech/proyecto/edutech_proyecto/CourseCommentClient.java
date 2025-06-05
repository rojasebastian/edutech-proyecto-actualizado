package com.edutech.proyecto.edutech_proyecto;


import com.edutech.proyecto.edutech_proyecto.dto.CourseCommentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-course-comment", url = "http://localhost:3306/api/course-commentaries")
public interface CourseCommentClient {
    @GetMapping("/{id}")
    CourseCommentDTO getCourseCommentById(@PathVariable("id") Integer id);

    @GetMapping("/course/{courseId}")
    List<CourseCommentDTO> getCommentsByCourseId(@PathVariable("courseId") Integer courseId);

    @GetMapping("/user/{userId}")
    List<CourseCommentDTO> getCommentsByUserId(@PathVariable("userId") Integer userId);

    @GetMapping("/course-user")
    List<CourseCommentDTO> getCommentsByCourseIdAndUserId(@RequestParam("courseId") Integer courseId,
                                                          @RequestParam("userId") Integer userId);

}
