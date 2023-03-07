package com.example.projetspring.repository;

import com.example.projetspring.entities.document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<document,Integer> {
}
