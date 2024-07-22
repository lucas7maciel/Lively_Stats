package com.example.springboot.graph;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/graph/")
@RequiredArgsConstructor
@Validated
public class GraphController {
    private final GraphService graphService;

    @GetMapping("/")
    public ResponseEntity<List<Graph>> getAll() {
        return ResponseEntity.ok().body(graphService.getAll());
    }

    @GetMapping("/requests")
    public Integer getRequests(@RequestParam(required = true) String animation) {
        return graphService.getRequests(animation);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Graph> getById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(graphService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Graph> save(@RequestParam(required = true) String animation) {
        return ResponseEntity.ok().body(graphService.save(animation));
    }

    @PutMapping("/")
    public ResponseEntity<Graph> update(@RequestBody Graph graph) {
        return ResponseEntity.ok().body(graphService.update(graph));
    }

    // @PutMapping("/request")
    // public ResponseEntity<Integer> makeRequest(@RequestParam(required = true) String animation) {
    //     return ResponseEntity.ok().body(graphService.makeRequest(animation));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        graphService.deleteById(id);
        return ResponseEntity.ok().body("Deleted graph successfully");
    }

}
