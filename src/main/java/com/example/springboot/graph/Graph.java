package com.example.springboot.graph;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "graphs")
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String animation;
    
    private Integer count = 0;
    private Integer usersCount = 0;
    private LocalDateTime lastUsed = LocalDateTime.now();

    public Graph(String animation) {
        this.animation = animation;
    }
}