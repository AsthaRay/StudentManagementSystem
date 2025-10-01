package com.example.demo.Dto;

import lombok.Data;

@Data
public class GenericResponse<T> {
    private T data;
    private boolean error;
    private String message;
}
