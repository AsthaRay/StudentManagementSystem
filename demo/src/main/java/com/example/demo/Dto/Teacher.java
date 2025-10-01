package com.example.demo.Dto;
import com.example.demo.model.Course;
import com.example.demo.model.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    private Role role;

    private List<Course> courses;
}
