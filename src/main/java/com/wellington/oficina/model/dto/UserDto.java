package com.wellington.oficina.model.dto;

import com.wellington.oficina.model.Employee;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private String role;
    private Employee employee;

}
