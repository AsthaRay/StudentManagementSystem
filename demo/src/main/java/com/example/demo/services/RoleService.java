package com.example.demo.services;
import com.example.demo.Dto.RoleDto;
import com.example.demo.Dto.StudentDto;
import com.example.demo.dtoFormatter.RoleDtoFormatter;
import com.example.demo.dtoFormatter.StudentDtoFormatter;
import com.example.demo.model.Role;
import com.example.demo.model.Student;
import com.example.demo.repository.RoleRepo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public RoleDto createRole(RoleDto roleRequestDto){
    Role roleEntity = RoleDtoFormatter.toRoleEnity(roleRequestDto);
    Role savedRole = roleRepo.save(roleEntity);
    RoleDto roleDto = RoleDtoFormatter.toRoleDto(savedRole);
    return roleDto;
    }
}
