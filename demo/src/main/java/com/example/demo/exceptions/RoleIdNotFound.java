package com.example.demo.exceptions;

public class RoleIdNotFound extends RuntimeException{
    public RoleIdNotFound(String message){
        super(message);
    }
}
