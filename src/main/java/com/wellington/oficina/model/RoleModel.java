package com.wellington.oficina.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wellington.oficina.model.enums.RoleType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "ROLES")
@Data
@AllArgsConstructor
public class RoleModel implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 30)
    private RoleType roleName;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.roleName.toString();
    }

}
