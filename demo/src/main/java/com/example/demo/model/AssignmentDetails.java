package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AssignmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int isDone;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "student_course_details_id")
    private StudentCourseDetails studentCourseDetails;
}
