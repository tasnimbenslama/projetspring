package com.example.projetspring.repository;

import com.example.projetspring.entities.event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface eventRepository extends JpaRepository<event,Integer> {

}
