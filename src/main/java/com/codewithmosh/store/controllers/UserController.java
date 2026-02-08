package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.UserDTO;
import com.codewithmosh.store.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> {
                    UserDTO dto = new UserDTO();
                    dto.setId(user.getId());
                    dto.setName(user.getName());
                    dto.setEmail(user.getEmail());
                    return dto;
                }).collect(Collectors.toList());
    }
}

