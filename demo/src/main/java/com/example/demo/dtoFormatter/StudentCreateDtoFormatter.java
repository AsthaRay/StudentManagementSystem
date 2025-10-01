package com.example.demo.dtoFormatter;

import com.example.demo.Dto.StudentCreateDto;
import com.example.demo.Dto.StudentDto;
import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentCreateDtoFormatter {
    public static StudentCreateDto toStudentCreateDto(Student student){
        StudentCreateDto dto = new StudentCreateDto();

        if (student.getRole() != null) {
            dto.setRoleId(student.getRole().getId());
        }

        if (student.getCourses() != null) {
            List<Long> courseIds = new ArrayList<>();
            for (int i = 0; i < student.getCourses().size(); i++) {
                courseIds.add(student.getCourses().get(i).getId());
            }
            dto.setCourseIds(courseIds);
        }

        return dto;
    }

    public static Student toStudentCreateEntity(StudentCreateDto studentCreateDto) {
        Student student = new Student();
        return student;
    }
}
