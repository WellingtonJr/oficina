package com.wellington.oficina.model.dto;

import com.wellington.oficina.model.Employee;
import com.wellington.oficina.model.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private UserRole role;
    private Employee employee;

}
