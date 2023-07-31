package com.wellington.oficina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellington.oficina.model.dto.LoginDto;
import com.wellington.oficina.model.dto.UserDto;
import com.wellington.oficina.service.RoleModelService;
import com.wellington.oficina.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    RoleModelService roleModelService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody @Validated LoginDto loginDto) {
        if (userService.existsByUsername(loginDto.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        loginDto.getRoles().forEach(role -> roleModelService.findByRoleName(role.getAuthority())
                .orElseThrow(() -> new RuntimeException("Role not found")));

        var user = new UserDto();
        user.setUsername(loginDto.getUsername());
        user.setPassword(loginDto.getPassword());
        user.setRoles(loginDto.getRoles());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

}
