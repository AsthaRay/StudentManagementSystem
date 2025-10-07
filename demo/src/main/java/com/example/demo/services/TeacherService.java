package com.example.demo.services;

import com.example.demo.Dto.TeacherRequestDto;
import com.example.demo.Dto.TeacherResponseDto;
import com.example.demo.exceptions.TeacherAlreadyExist;
import com.example.demo.exceptions.TeacherCreateError;
import com.example.demo.model.Course;
import com.example.demo.model.CourseAction;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    public TeacherResponseDto createTeacher(TeacherRequestDto teacherRequestDto) {
        Teacher teacherEntity = new Teacher();
        if (
                teacherRequestDto.getName() == null
                        || teacherRequestDto.getEmail() == null
                        || teacherRequestDto.getName().trim().isEmpty()
                        || teacherRequestDto.getEmail().trim().isEmpty()) {
            throw new TeacherCreateError();

        }
        List<Teacher> teachers = teacherRepo.findByEmail(teacherRequestDto.getEmail().trim());
        if (!teachers.isEmpty()) {
            throw new TeacherAlreadyExist();
        }
        teacherEntity.setName(teacherRequestDto.getName());
        teacherEntity.setEmail(teacherRequestDto.getEmail());
        Teacher savedTeacher = teacherRepo.save(teacherEntity);
        TeacherResponseDto teacherResponseDto = new TeacherResponseDto();
        teacherResponseDto.setTeacher_id(teacherEntity.getTeacher_id());
        teacherResponseDto.setName(teacherEntity.getName());
        teacherResponseDto.setEmail(teacherEntity.getEmail());
        teacherResponseDto.setCourseAction(CourseAction.ASSIGN_TEACHER);
        return teacherResponseDto;
    }

    public List<TeacherResponseDto> fetchTeacher() {
        List<Teacher> teachers = teacherRepo.findAll();
        List<TeacherResponseDto> teacherResponseDto = new ArrayList<>();
        TeacherResponseDto teacherResponseDto1 = new TeacherResponseDto();
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            List<Course> courses = teacher.getCourses();
            if(!courses.isEmpty()){
                teacher.setCourses(courses);
            };
            Course course = courses.get(i);
            teacherResponseDto1.setCourse_id(course.getCourse_id());
            teacherResponseDto1.setTeacher_id(teacher.getTeacher_id());
            teacherResponseDto1.setName(teacher.getName());
            teacherResponseDto.add(teacherResponseDto1);
        }
        return teacherResponseDto;
    }
    public TeacherResponseDto fetchTeacher(Long teacher_id){
        Optional<Teacher> teacherEnity = teacherRepo.findById(teacher_id);
        Teacher teacher = teacherEnity.get();
        TeacherResponseDto teacherResponseDto = new TeacherResponseDto();
       return teacherResponseDto;
    }

}
