package com.example.springboot.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User createUser(String name) {
        User user = new User();

        user.setName(name);
        user.setFirstUsed(LocalDate.now());
        user.setLastUsed(LocalDate.now());

        return userRepo.save(user);
    }
}
