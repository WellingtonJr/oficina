package com.wellington.oficina.model.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private String name;

    private String cpf;

    private String phone;

    private Double salary;

    private Double bonus;

    private Double commission;
}
