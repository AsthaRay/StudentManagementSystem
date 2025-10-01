package com.example.demo.services;

import com.example.demo.Dto.StudentCreateDto;
import com.example.demo.Dto.StudentDto;
import com.example.demo.dtoFormatter.StudentCreateDtoFormatter;
import com.example.demo.dtoFormatter.StudentDtoFormatter;
import com.example.demo.exceptions.RoleIdNotFound;
import com.example.demo.model.Course;
import com.example.demo.model.Role;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.StudentRepo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private CourseRepo courseRepo;


    public StudentDto createStudent(StudentDto studentRequestDto) {
        Student studentEntity = StudentDtoFormatter.toStudentEntity(studentRequestDto);
        Student savedStudent = studentRepo.save(studentEntity);
        StudentDto studentDto = StudentDtoFormatter.toStudentDto(savedStudent);
        return studentDto;
    }

    public StudentCreateDto insertStudentDetails(StudentCreateDto studentCreateDto) {
        Student studentEntity = StudentCreateDtoFormatter.toStudentCreateEntity(studentCreateDto);
        if (studentCreateDto.getRoleId() == null) {
            throw new RoleIdNotFound("Role id is mandatory");
        }
        Optional<Role> optionalRole = roleRepo.findById(studentCreateDto.getRoleId());
        if (optionalRole.isPresent()) {
            studentEntity.setRole(optionalRole.get());
        } else {
            throw new RoleIdNotFound("Role not found with id: " + studentCreateDto.getRoleId());
        }
        if (studentCreateDto.getCourseIds() != null && !studentCreateDto.getCourseIds().isEmpty()) {
            List<Course> courses = courseRepo.findAllById(studentCreateDto.getCourseIds());
            studentEntity.setCourses(courses);
        }
        Student savedStudent = studentRepo.save(studentEntity);
        return StudentCreateDtoFormatter.toStudentCreateDto(savedStudent);
    }


}
