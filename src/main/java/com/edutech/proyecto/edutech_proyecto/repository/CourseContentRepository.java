package com.edutech.proyecto.edutech_proyecto.repository;

import com.edutech.proyecto.edutech_proyecto.entity.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseContentRepository extends JpaRepository<CourseContent, Integer> {

    List<CourseContent> findByCourseId(Integer courseId);

    List<CourseContent> findByTitleContainingIgnoreCase(String title);



}
