package com.example.demo.Dto;

import com.example.demo.model.Course;
import com.example.demo.model.CourseAction;
import lombok.Data;

@Data
public class TeacherResponseDto {
    private Long teacher_id;
    private String name;
    private String email;
    private CourseAction courseAction;
    private Long course_id;
}
