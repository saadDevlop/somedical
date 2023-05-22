package com.pfa.SOmedical.somedical.Entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Infirmier implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idInfirmier;
    private String NomInf;
    private String mail;
    private String mdp;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "rendinf", joinColumns = { @JoinColumn(name = "idInfirmier") }, inverseJoinColumns = {
            @JoinColumn(name = "idRen") })
    private List<Rendezvous> rendezvous;
}