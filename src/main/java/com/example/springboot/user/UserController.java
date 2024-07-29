package com.example.springboot.user;

import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @GetMapping("/name")
    public ResponseEntity<User> getByName(@RequestParam(required = true) String name) {
        return ResponseEntity.ok().body(userService.getByName(name));
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestParam(required = true) String name) {
        return ResponseEntity.ok().body(userService.create(name));
    }
}
