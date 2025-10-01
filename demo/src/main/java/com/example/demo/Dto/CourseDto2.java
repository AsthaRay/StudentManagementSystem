package com.example.demo.Dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto2 {
    private Long teacherId;
    private List<Long> studentIds;
}
