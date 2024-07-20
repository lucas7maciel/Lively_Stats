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
    public ResponseEntity<List<Graph>> getAllGraphs(){
        return ResponseEntity.ok().body(graphService.getAllGraphs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Graph> getGraphById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(graphService.getGraphById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Graph> saveGraph(@RequestParam(required = true) String animation)
    {
        return ResponseEntity.ok().body(graphService.saveGraph(animation));
    }

    @PutMapping("/")
    public ResponseEntity<Graph> updateGraph(@RequestBody Graph graph)
    {
        return ResponseEntity.ok().body(graphService.updateGraph(graph));
    }

    @PutMapping("/request")
    public ResponseEntity<Integer> makeRequest(@RequestParam(required = true) String animation)
    {
        return ResponseEntity.ok().body(graphService.makeRequest(animation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGraphById(@PathVariable Integer id)
    {
        graphService.deleteGraphById(id);
        return ResponseEntity.ok().body("Deleted graph successfully");
    }
    
}
