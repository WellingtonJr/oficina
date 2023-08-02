package com.wellington.oficina.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellington.oficina.model.Employee;
import com.wellington.oficina.model.User;
import com.wellington.oficina.model.dto.UserDto;
import com.wellington.oficina.repository.RoleModelRepository;
import com.wellington.oficina.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleModelRepository roleModelRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User save(UserDto userDto) {
        var user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        user.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        userDto.getRoles()
                .forEach(role -> user.getRoles().add(roleModelRepository.findByRoleName(role)
                        .orElseThrow(() -> new RuntimeException("Role not found"))));

        return userRepository.save(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmployee(Employee employee) {
        return userRepository.existsByEmployee(employee);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> getOne(UUID id) {
        return userRepository.findById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

}
