package com.example.projetspring.repository;

import com.example.projetspring.entities.team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TeamRepository extends JpaRepository<team,Integer> {
    @Query("select e from team e where e.eventt.idEv =:idEv")
    List<team> getAllBy(@PathVariable("idEv ")Integer idEv);

}
