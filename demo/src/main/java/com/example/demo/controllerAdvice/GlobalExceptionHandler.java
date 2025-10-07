package com.example.demo.controllerAdvice;

import com.example.demo.Dto.GenericResponse;
import com.example.demo.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoleIdNotFound.class)
    public ResponseEntity<GenericResponse<Object>> handleRoleNotFoundException(){
        GenericResponse<Object> genericResponse = new GenericResponse<>();
        genericResponse.setError(true);
        genericResponse.setMessage("Role id not found");
        return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CourseNotFound.class)
    public ResponseEntity<GenericResponse<Object>> handleCourseNotFoundException(){
        GenericResponse<Object> genericResponse = new GenericResponse<>();
        genericResponse.setError(true);
        genericResponse.setMessage("Course not found");
        return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CourseCreateError.class)
    public ResponseEntity<GenericResponse<Object>> handleCourseCreateErrorException(){
        GenericResponse<Object> genericResponse = new GenericResponse<>();
        genericResponse.setError(true);
        genericResponse.setMessage("Name and code is required");
        return new ResponseEntity<>(genericResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseAlreadyExist.class)
    public ResponseEntity<GenericResponse<Object>> handleCourseAlreadyExistException(){
        GenericResponse<Object> genericResponse = new GenericResponse<>();
        genericResponse.setError(true);
        genericResponse.setMessage("The course you are trying to insert is already exist");
        return new ResponseEntity<>(genericResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeacherCreateError.class)
    public ResponseEntity<GenericResponse<Object>> handleTeacherException(){
        GenericResponse<Object> genericResponse = new GenericResponse<>();
        genericResponse.setError(true);
        genericResponse.setMessage("Name and Email is mandatory");
        return new ResponseEntity<>(genericResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeacherAlreadyExist.class)
    public ResponseEntity<GenericResponse<Object>> handleTeacherALreadyExistException(){
        GenericResponse<Object> genericResponse = new GenericResponse<>();
        genericResponse.setError(true);
        genericResponse.setMessage("Teacher with that name already exist !");
        return new ResponseEntity<>(genericResponse,HttpStatus.BAD_REQUEST);
    }
}

