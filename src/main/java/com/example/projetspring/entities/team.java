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
public class team  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idT;
    private String name;
    @JsonIgnore
    @ManyToOne
    private project projects;
    @JsonIgnore
    @ManyToOne
    event eventt;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Set<User> userSet;
    public team( int id,String name) {
        this.idT =id;
        this.name = name;

    }

}
