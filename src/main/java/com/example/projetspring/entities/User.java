package com.example.projetspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String Lastname;
    private String Firstname;
    private String email;
    private Boolean available;
    private String sexe;
    private String Role;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<event> events;

}
