package com.example.demo.controllers;

import com.example.demo.Dto.GenericResponse;
import com.example.demo.Dto.StudentCreateDto;
import com.example.demo.Dto.StudentDto;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/createStudent")
    public GenericResponse<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        GenericResponse<StudentDto> genericResponse = new GenericResponse<>();
        genericResponse.setError(false);
        genericResponse.setMessage("Student is added successfully");
        genericResponse.setData(studentService.createStudent(studentDto));
        return genericResponse;
    }

    @PostMapping("/insertStudentDetails")
    public GenericResponse<StudentCreateDto> insertStudentDetails(@RequestBody StudentCreateDto studentCreateDto){
        GenericResponse<StudentCreateDto> genericResponse = new GenericResponse<>();
        genericResponse.setError(false);
        genericResponse.setMessage("Student details are added successfully");
        genericResponse.setData(studentService.insertStudentDetails(studentCreateDto));
        return genericResponse;
    }

}
