package com.example.springboot.graph;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.example.springboot.request.Request;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "graphs")
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String animation;

    @OneToMany(mappedBy = "graph")
    private List<Request> requests;
    
    private Integer count = 0;
    private Integer usersCount = 0;
    private LocalDateTime lastUsed = LocalDateTime.now();

    public Graph(String animation) {
        this.animation = animation;
    }
}