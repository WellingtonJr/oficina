package com.wellington.oficina.model.dto;

import java.util.Set;

import com.wellington.oficina.model.Employee;
import com.wellington.oficina.model.RoleModel;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private String role;
    private Employee employee;
    private Set<RoleModel> roles;

}
