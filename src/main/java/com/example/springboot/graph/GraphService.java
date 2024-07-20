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

    public List<Graph> getAllGraphs() {
        return graphRepo.findAll();
    }

    public Graph getGraphById(Integer id) {
        Optional<Graph> optionalGraph = graphRepo.findById(id);

        if (optionalGraph.isPresent()) {
            return optionalGraph.get();
        }

        return null;
    }

    // Isso aqui na vdd vai ser no update eu acho
    public Graph saveGraph(String animation) {
        Graph graph = new Graph();

        graph.setAnimation(animation);
        graph.setCount(0);
        graph.setUsersCount(0);
        graph.setLastUsed(LocalDateTime.now());

        return graphRepo.save(graph);
    }

    public Graph updateGraph(Graph graph) {
        // Mudar contador tb
        graph.setCount(graph.getCount() + 1);
        graph.setLastUsed(LocalDateTime.now());

        Graph updatedGraph = graphRepo.save(graph);

        return updatedGraph;
    }

    public int makeRequest(String animation) {
        List<Graph> allGraphs = graphRepo.findAll();
        Graph selectedGraph = null;

        for (Graph graph : allGraphs) {
            if (!animation.equals(graph.getAnimation())) {
                continue;
            }

            graph.setCount(graph.getCount() + 1);
            selectedGraph = graph;

            graphRepo.save(selectedGraph);
        }

        if (selectedGraph == null) {
            return -1;
        }

        return selectedGraph.getCount();
    }

    public void deleteGraphById(Integer id) {
        graphRepo.deleteById(id);
    }
}
