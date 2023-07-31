package com.wellington.oficina.model.dto;

import java.util.Set;

import com.wellington.oficina.model.RoleModel;

import lombok.Data;

@Data
public class LoginDto {

    private String username;
    private String password;
    private Set<RoleModel> roles;
}
