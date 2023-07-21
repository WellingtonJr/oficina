package com.wellington.oficina.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellington.oficina.model.Employee;
import com.wellington.oficina.model.dto.EmployeeDto;
import com.wellington.oficina.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(EmployeeDto employeeDto) {
        var employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        employee.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        return employeeRepository.save(employee);
    }

    public boolean existsByCpf(String cpf) {
        return employeeRepository.existsByCpf(cpf);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findOne(UUID id) {
        return employeeRepository.findById(id);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

}
