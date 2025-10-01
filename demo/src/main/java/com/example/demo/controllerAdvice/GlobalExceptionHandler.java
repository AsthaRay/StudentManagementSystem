package com.example.demo.controllerAdvice;

import com.example.demo.Dto.GenericResponse;
import com.example.demo.exceptions.RoleIdNotFound;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoleIdNotFound.class)
    public GenericResponse<Object> handleParkingLotNotFoundException(){
        GenericResponse<Object> genericResponse = new GenericResponse<>();
        genericResponse.setError(true);
        genericResponse.setMessage("Role id not found");
        return genericResponse;
    }
}
