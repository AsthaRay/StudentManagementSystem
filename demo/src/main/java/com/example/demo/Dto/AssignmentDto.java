package com.example.demo.Dto;

import com.example.demo.model.StudentCourseDetails;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
public class AssignmentDto {
    private Long id;
    private String name;

    private String description;
    private String dueDate;
    private int daysRemaining;
    private List<StudentCourseDetails> courseDetails;

}
