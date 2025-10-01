package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;

    private String password;
    private String firstName;
    private String lastName;
    private String email;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;


    @OneToMany(mappedBy = "student")
    private List<StudentCourseDetails> studentCourseDetails;
    @ManyToMany
    @JoinTable(
            name = "courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
// create student pass role_id
//create studentDto
