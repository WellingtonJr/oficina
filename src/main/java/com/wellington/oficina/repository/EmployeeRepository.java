package com.wellington.oficina.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.oficina.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    boolean existsByCpf(String cpf);

}
