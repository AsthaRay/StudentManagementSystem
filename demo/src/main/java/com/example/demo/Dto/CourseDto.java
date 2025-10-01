package com.example.demo.Dto;
import com.example.demo.model.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
public class CourseDto {
    private Long id;
    private String code;
    private String name;
}
