package com.example.demo.Dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AssignmentDetailsDto {
    private Long id;
    private int assignmentId;

    private int studentCourseDetailsId;
    private int isDone;
}
