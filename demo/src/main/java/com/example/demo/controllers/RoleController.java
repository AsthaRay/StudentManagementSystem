package com.example.demo.controllers;

import com.example.demo.Dto.GenericResponse;
import com.example.demo.Dto.RoleDto;
import com.example.demo.Dto.StudentDto;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public GenericResponse<RoleDto> createRole(@RequestBody RoleDto roleDto){
        GenericResponse<RoleDto> genericResponse = new GenericResponse<>();
        genericResponse.setError(false);
        genericResponse.setMessage("Role is added successfully");
        genericResponse.setData(roleService.createRole(roleDto));
        return genericResponse;
    }
}
