package com.wellington.oficina.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.oficina.model.Employee;
import com.wellington.oficina.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);

    boolean existsByEmployee(Employee employee);

    @EntityGraph(attributePaths = { "roles" }, type = EntityGraph.EntityGraphType.FETCH)
    Optional<User> findByUsername(String username);

}
