package com.example.demo.dtoFormatter;

import com.example.demo.Dto.RoleDto;
import com.example.demo.model.Role;

public class RoleDtoFormatter {
    public static RoleDto toRoleDto(Role roleEntity){
        RoleDto roleDto = new RoleDto();
       roleDto.setId(roleEntity.getId());
       roleDto.setName(roleEntity.getName());
        return roleDto;
    }
    public static Role toRoleEnity(RoleDto roleDto){
        Role roleEntity = new Role();
        roleEntity.setId(roleDto.getId());
        roleEntity.setName(roleDto.getName());
        return roleEntity;
    }
}
