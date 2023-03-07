package com.example.projetspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class project  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="projects")
    private Set<team> teams;
    @JsonIgnore

    @OneToMany(cascade = CascadeType.ALL, mappedBy="proj")
    private Set<document> doc;
    @JsonIgnore

    @OneToMany(cascade = CascadeType.ALL, mappedBy="projectt")
    private Set<followed> followeds;
}


