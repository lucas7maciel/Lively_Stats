package com.example.springboot.user;

import java.time.LocalDate;
import java.util.List;

import com.example.springboot.request.Request;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    private LocalDate firstUsed = LocalDate.now();
    private LocalDate lastUsed = LocalDate.now();

    public User(String name) {
        this.name = name;
    }
}
