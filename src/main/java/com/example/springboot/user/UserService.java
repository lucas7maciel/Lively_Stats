package com.example.springboot.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getByName(String username) {
        return userRepo.getByName(username);
    }

    public User create(String username) {
        User user = new User(username);

        return userRepo.save(user);
    }
}
