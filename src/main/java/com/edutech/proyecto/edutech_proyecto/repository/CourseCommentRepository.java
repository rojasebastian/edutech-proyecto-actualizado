package com.edutech.proyecto.edutech_proyecto.repository;


import com.edutech.proyecto.edutech_proyecto.entity.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCommentRepository extends JpaRepository<CourseComment, Integer> {
    List<CourseComment> findByCourse_Id(Integer courseId);
    List<CourseComment> findByUser_Id(Integer userId);
    List<CourseComment> findByCourse_IdAndUser_Id(Integer courseId, Integer userId);


}
