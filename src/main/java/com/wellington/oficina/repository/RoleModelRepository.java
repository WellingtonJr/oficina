package com.wellington.oficina.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.oficina.model.RoleModel;

public interface RoleModelRepository extends JpaRepository<RoleModel, UUID> {

    Optional<RoleModel> findByRoleName(String roleName);

}
