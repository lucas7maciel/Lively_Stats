package com.example.springboot.graph;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class GraphService {
    private final GraphRepo graphRepo;

    public List<Graph> getAll() {
        return graphRepo.findAll();
    }

    public Graph getById(Integer id) {
        Optional<Graph> optionalGraph = graphRepo.findById(id);

        if (optionalGraph.isPresent()) {
            return optionalGraph.get();
        }

        return null;
    }

    public Integer getRequests(String animation) {
        return graphRepo.getRequests(animation);
    }

    public Graph getByAnimation(String animation) {
        return graphRepo.getByAnimation(animation);
    }

    // Isso aqui na vdd vai ser no update eu acho
    public Graph save(String animation) {
        Graph graph = new Graph(animation);

        return graphRepo.save(graph);
    }

    public Graph update(Graph graph) {
        // Mudar contador tb
        graph.setCount(graph.getCount() + 1);
        graph.setLastUsed(LocalDateTime.now());

        Graph updatedGraph = graphRepo.save(graph);

        return updatedGraph;
    }
    
    public void deleteById(Integer id) {
        graphRepo.deleteById(id);
    }
}
