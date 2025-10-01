package com.example.demo.Dto;
import com.example.demo.model.Assignment;
import com.example.demo.model.GradeDetails;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class StudentCourseDetailsDto {
    private Long id;
    private int studentId;
    private int courseId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="assignment_details",
            joinColumns = @JoinColumn(name="student_course_details_id"),
            inverseJoinColumns = @JoinColumn(name="assignment_id"))
    private List<Assignment> assignments;

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="grade_details_id")
    private GradeDetails gradeDetails;
}
