package com.example.demo.services;

import com.example.demo.Dto.CourseRequestDto;
import com.example.demo.Dto.CourseResponseDto;
import com.example.demo.exceptions.CourseAlreadyExist;
import com.example.demo.exceptions.CourseCreateError;
import com.example.demo.exceptions.CourseNotFound;
import com.example.demo.model.Course;
import com.example.demo.model.CourseAction;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.naming.SelectorContext.prefix;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) {
        Course courseEntity = new Course();
        if (
                courseRequestDto.getCourse_name() == null
                        || courseRequestDto.getCourse_code() == null
                        || courseRequestDto.getCourse_name().trim().isEmpty()
                        || courseRequestDto.getCourse_code().trim().isEmpty()
        ) {
            throw new CourseCreateError();
        }
        List<Course> courses = courseRepo.findByCode(courseRequestDto.getCourse_code().trim());
        if (!courses.isEmpty()) {
            throw new CourseAlreadyExist();
        }

        courseEntity.setCourse_name(courseRequestDto.getCourse_name().trim());
        courseEntity.setCourse_code(courseRequestDto.getCourse_code().trim());
        Course savedCourse = courseRepo.save(courseEntity);

        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setCourse_id(courseEntity.getCourse_id());
        courseResponseDto.setCourse_name(courseEntity.getCourse_name());
        courseResponseDto.setCourse_code(courseEntity.getCourse_code());
        if (savedCourse.getTeacher() == null) {
            courseResponseDto.setAction(CourseAction.ASSIGN_TEACHER);
        } else {
            courseResponseDto.setAction(CourseAction.RE_ASSIGN_TEACHER);
        }
        return courseResponseDto;
    }

    public List<CourseResponseDto> fetchCourse(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new CourseCreateError();
        }
        List<Course> courseEntity = courseRepo.findByNameStartingWithIgnoreCase(name);
        ;
        List<CourseResponseDto> courseResponseDtos = new ArrayList<>();
        for (int i = 0; i < courseEntity.size(); i++) {
            CourseResponseDto courseResponseDto = new CourseResponseDto();
            Course course = courseEntity.get(i);
            courseResponseDto.setCourse_id(course.getCourse_id());
            courseResponseDto.setCourse_name(course.getCourse_name());
            courseResponseDto.setCourse_code(course.getCourse_code());
            courseResponseDtos.add(courseResponseDto);
        }
        return courseResponseDtos;
    }

    public List<CourseResponseDto> fetchCourse() {
        List<Course> courseEntity1 = courseRepo.findAll();
        List<CourseResponseDto> courseResponseDtos1 = new ArrayList<>();
        for (int i = 0; i < courseEntity1.size(); i++) {
            CourseResponseDto courseResponseDto = new CourseResponseDto();
            Course course = courseEntity1.get(i);
            courseResponseDto.setCourse_id(course.getCourse_id());
            courseResponseDto.setCourse_name(course.getCourse_name());
            courseResponseDto.setCourse_code(course.getCourse_code());
            courseResponseDtos1.add(courseResponseDto);
        }
        return courseResponseDtos1;

    }

    public CourseResponseDto getCourseById(Long id) {
        Optional<Course> courseEntity = courseRepo.findById(id);
        if (courseEntity.isEmpty()) {
            throw new CourseNotFound();
        }
        Course course = courseEntity.get();
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setCourse_id(course.getCourse_id());
        courseResponseDto.setCourse_name(course.getCourse_name());
        courseResponseDto.setCourse_code(course.getCourse_code());
        return courseResponseDto;

    }

    public CourseResponseDto assignTeacher(Long course_id, Long teacher_id) {
        Optional<Course> course = courseRepo.findById(course_id);
        Course course1 = course.get();
        Optional<Teacher> teacher = teacherRepo.findById(teacher_id);
        Teacher teacher1 = teacher.get();
        course1.setTeacher(teacher1);
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setTeacher_id(course1.getTeacher().getTeacher_id());
        if (course1.getTeacher() == null) {
            courseResponseDto.setAction(CourseAction.NOT_ASSIGN);
        } else {
            courseResponseDto.setAction(CourseAction.ASSIGN_TEACHER);
        }
        return courseResponseDto; // isme optional ki error hsandle nhi ki hai
    }

}
// courseCode should not be same or exist in db