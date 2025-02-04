package com.example.springboot.request;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/request/")
@RequiredArgsConstructor
@Validated
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/")
    public ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok().body(requestService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Request> create(@RequestParam(required = true) String animation,
            @RequestParam(required = true) String username) {
        return ResponseEntity.ok().body(requestService.makeRequest(animation, username));
    }

    @GetMapping("/name")
    public ResponseEntity<Request> getByInfo(@RequestParam(required = true) String username,
            @RequestParam(required = true) String animation) {
        return ResponseEntity.ok().body(requestService.getByInfo(username, animation));
    }
}
