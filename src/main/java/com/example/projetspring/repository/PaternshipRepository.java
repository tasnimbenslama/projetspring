package com.example.projetspring.repository;

import com.example.projetspring.entities.paternship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaternshipRepository extends JpaRepository<paternship,Integer> {
    List<paternship> findByNameContainingIgnoreCase(String name);
}
