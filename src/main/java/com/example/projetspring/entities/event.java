package com.example.projetspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class event implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     int idEv;
    @NotBlank(message = "Le materiels doit etre  definie")
     String materials;
    @Max(value = 1000, message = "le budget doit etre maximum 1000")
     int budget;
    @Temporal(TemporalType.DATE)

     Date startDate;
     Date endDate;
     String speaker;
     String participant;
     @JsonIgnore
    @ManyToMany(mappedBy="events", cascade = CascadeType.ALL)
     Set<User> users;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="eventt")
     Set<team> teamSet;
    public event( int id,Date startDate) {
        this.idEv =id;
        this.startDate = startDate;

    }

}
