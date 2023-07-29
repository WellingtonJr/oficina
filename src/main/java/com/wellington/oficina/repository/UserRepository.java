package com.wellington.oficina.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.wellington.oficina.model.Employee;
import com.wellington.oficina.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);

    boolean existsByEmployee(Employee employee);

    UserDetails findByUsername(String username);

}
