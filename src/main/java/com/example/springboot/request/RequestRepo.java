package com.example.springboot.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RequestRepo extends JpaRepository<Request, Integer> {
    @Query("SELECT r FROM Request r WHERE r.user.name = ?1 AND r.graph.animation = ?2")
    Request getRequestByNameAndAnimation(String userName, String animation);
}
