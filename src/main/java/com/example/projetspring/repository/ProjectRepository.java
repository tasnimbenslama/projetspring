package com.example.projetspring.repository;

import com.example.projetspring.entities.project;
import com.example.projetspring.entities.team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<project,Integer> {

}
