package com.example.demo.dtoFormatter;

import com.example.demo.Dto.StudentDto;
import com.example.demo.model.Student;

public class StudentDtoFormatter {
    public static StudentDto toStudentDto(Student studentEntity){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setUserName(studentEntity.getUserName());
        studentDto.setFirstName(studentEntity.getFirstName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setEmail(studentEntity.getEmail());
        studentDto.setPassword(studentDto.getPassword());
        return studentDto;
    }

    public static Student toStudentEntity(StudentDto studentDto){
        Student studentEntity = new Student();
        studentEntity.setId(studentDto.getId());
        studentEntity.setUserName(studentDto.getUserName());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setPassword(studentDto.getPassword());
        return studentEntity;
   }
}
