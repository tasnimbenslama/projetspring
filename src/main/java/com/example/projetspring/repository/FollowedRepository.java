package com.example.projetspring.repository;

import com.example.projetspring.entities.followed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FollowedRepository extends JpaRepository<followed,Integer> {

    List<followed> findTop3ByOrderByNoteDesc();
}
