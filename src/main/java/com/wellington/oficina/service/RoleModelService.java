package com.wellington.oficina.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellington.oficina.model.RoleModel;
import com.wellington.oficina.repository.RoleModelRepository;

@Service
public class RoleModelService {

    @Autowired
    private RoleModelRepository roleModelRepository;

    public Optional<RoleModel> findByRoleName(String roleName) {
        return roleModelRepository.findByRoleName(roleName);
    }

}
