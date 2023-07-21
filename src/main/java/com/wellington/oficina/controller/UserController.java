package com.wellington.oficina.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellington.oficina.model.User;
import com.wellington.oficina.model.dto.UserDto;
import com.wellington.oficina.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserDto userDto) {

        if (userService.existsByUsername(userDto.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        if (userService.existsByEmployee(userDto.getEmployee())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee already exists as user");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));

    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

}
