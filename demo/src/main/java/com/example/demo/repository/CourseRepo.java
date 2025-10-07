package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
     List<Course> findByCode(String course_code);

    List<Course> findByName(String course_name);
    List<Course> findByNameStartingWithIgnoreCase(String prefix);

}
