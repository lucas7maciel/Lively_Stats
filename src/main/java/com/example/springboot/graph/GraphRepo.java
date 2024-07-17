package com.example.springboot.graph;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphRepo extends JpaRepository<Graph, Integer> {
    
}
