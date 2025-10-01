package com.example.demo.repository;

import com.example.demo.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeDetailsRepo extends JpaRepository<com.example.demo.model.GradeDetails,Long> {
}
