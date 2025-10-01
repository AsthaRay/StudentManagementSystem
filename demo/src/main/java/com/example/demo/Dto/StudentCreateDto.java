package com.example.demo.Dto;

import com.example.demo.model.Course;
import com.example.demo.model.Role;
import com.example.demo.model.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentCreateDto {
    private Long roleId;
    private List<Long> courseIds;
}

