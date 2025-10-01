package com.example.demo.repository;

import com.example.demo.model.Assignment;
import com.example.demo.model.AssignmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentDetailsRepo extends JpaRepository<AssignmentDetails,Long> {
}
