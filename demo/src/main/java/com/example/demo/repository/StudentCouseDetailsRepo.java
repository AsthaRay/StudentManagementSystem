package com.example.demo.repository;

import com.example.demo.model.Assignment;
import com.example.demo.model.StudentCourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCouseDetailsRepo extends JpaRepository<StudentCourseDetails,Long> {
}
