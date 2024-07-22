package com.example.springboot.graph;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GraphRepo extends JpaRepository<Graph, Integer> {
    @Query("SELECT g FROM Graph g WHERE g.animation = ?1")
    Graph getGraphByAnimation(String animation);

    @Query("SELECT Sum(r.count) FROM Request r WHERE r.graph.animation = ?1")
    Integer getGraphRequests(String animation);    
}
