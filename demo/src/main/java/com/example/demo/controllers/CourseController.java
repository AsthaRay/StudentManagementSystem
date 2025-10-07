package com.example.demo.controllers;

import com.example.demo.Dto.CourseRequestDto;
import com.example.demo.Dto.CourseResponseDto;
import com.example.demo.Dto.GenericResponse;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping()
    public ResponseEntity<GenericResponse<CourseResponseDto>> createCourse(@RequestBody CourseRequestDto courseRequestDto){
        GenericResponse<CourseResponseDto> genericResponse = new GenericResponse<>();
        genericResponse.setError(false);
        genericResponse.setMessage("Course is added successfully");
        genericResponse.setData(courseService.createCourse(courseRequestDto));
        return new ResponseEntity<>(genericResponse, HttpStatus.CREATED);
    }

    @GetMapping(params = "name") // we cant do {name} why ??
    public ResponseEntity<GenericResponse<List<CourseResponseDto>>> fetchCourse(@RequestParam String name){
        GenericResponse<List<CourseResponseDto>> genericResponse = new GenericResponse<>();
        genericResponse.setError(false);
        genericResponse.setMessage("The course you ar searching for");
        genericResponse.setData(courseService.fetchCourse(name));
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<GenericResponse<List<CourseResponseDto>>> fetchCourse(){
        GenericResponse<List<CourseResponseDto>> genericResponse = new GenericResponse<>();
        genericResponse.setError(false);
        genericResponse.setMessage("The course you ar searching for");
        genericResponse.setData(courseService.fetchCourse());
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    //getbyid use routr param
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseResponseDto>> getCourseById(@PathVariable Long id){
        GenericResponse<CourseResponseDto> genericResponse = new GenericResponse<>();
        genericResponse.setError(false);
        genericResponse.setMessage("The course you ar searching for");
        genericResponse.setData(courseService.getCourseById(id));
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }



}
