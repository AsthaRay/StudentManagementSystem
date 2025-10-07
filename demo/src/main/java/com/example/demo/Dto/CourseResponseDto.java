package com.example.demo.Dto;
import com.example.demo.model.CourseAction;
import com.example.demo.model.Teacher;
import lombok.Data;


@Data
public class CourseResponseDto {
    private Long course_id;
    private String course_code;
    private String course_name;
    private CourseAction action;
    private Long teacher_id;

    //teacher name should be returned if teacher name is already avail for course so assign teachername otherwise put NA

}
