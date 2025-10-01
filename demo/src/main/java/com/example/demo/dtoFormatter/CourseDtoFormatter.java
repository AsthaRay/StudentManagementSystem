package com.example.demo.dtoFormatter;

import com.example.demo.Dto.CourseDto;
import com.example.demo.model.Course;

public class CourseDtoFormatter {
    public static CourseDto toCourseEntity(Course courseEntity){
       CourseDto courseDto = new CourseDto();
       courseDto.setId(courseEntity.getId());
       courseDto.setName(courseEntity.getName());
       courseDto.setCode(courseEntity.getCode());
       return courseDto;
    }

    public static Course toCourseDto(CourseDto courseDto){
        Course courseEntity = new Course();
        courseEntity.setId(courseDto.getId());
        courseEntity.setName(courseDto.getName());
        courseEntity.setCode(courseDto.getCode());
        return courseEntity;
    }
}
