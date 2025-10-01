package com.example.demo.Dto;
import com.example.demo.model.StudentCourseDetails;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class GradeDetailsDto {
    private Long id;
    public Integer gradeOne;

    public Integer gradeTwo;
    public Integer gradeThree;
    private StudentCourseDetails studentCourseDetails;

}
