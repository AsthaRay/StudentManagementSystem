package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;
    private String name;
    private String email;

    @OneToMany(mappedBy="teacher", fetch=FetchType.EAGER)
    private List<Course> courses;
}
