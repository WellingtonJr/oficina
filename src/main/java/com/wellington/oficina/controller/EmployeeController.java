package com.wellington.oficina.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellington.oficina.model.dto.EmployeeDto;
import com.wellington.oficina.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody EmployeeDto employeeDto) {

        if (employeeService.existsByCpf(employeeDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF already exists");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeDto));

    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") UUID id) {
        var employee = employeeService.findOne(id);
        if (!employee.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee.get());
    }

}
