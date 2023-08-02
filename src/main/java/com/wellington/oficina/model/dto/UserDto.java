package com.wellington.oficina.model.dto;

import java.util.List;

import com.wellington.oficina.model.Employee;
import com.wellington.oficina.model.enums.RoleType;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private Employee employee;
    private List<RoleType> roles;

}
