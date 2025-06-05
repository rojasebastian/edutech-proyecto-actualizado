package com.edutech.proyecto.edutech_proyecto.repository;


import com.edutech.proyecto.edutech_proyecto.entity.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCommentRepository extends JpaRepository<CourseComment, Integer> {
    List<CourseComment> findByCourseId(Integer courseId);
    List<CourseComment> findByUserId(Integer userId);
    List<CourseComment> findByCourseIdAndUserId(Integer courseId, Integer userId);


}
