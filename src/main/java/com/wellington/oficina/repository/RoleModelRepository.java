package com.wellington.oficina.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.oficina.model.RoleModel;
import com.wellington.oficina.model.enums.RoleType;

public interface RoleModelRepository extends JpaRepository<RoleModel, UUID> {

    Optional<RoleModel> findByRoleName(RoleType roleName);

}
