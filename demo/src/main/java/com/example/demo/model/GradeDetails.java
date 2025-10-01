package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GradeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer gradeOne;
    private Integer gradeTwo;
    private Integer gradeThree;

    @OneToOne(mappedBy = "gradeDetails",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private StudentCourseDetails studentCourseDetails;

}
