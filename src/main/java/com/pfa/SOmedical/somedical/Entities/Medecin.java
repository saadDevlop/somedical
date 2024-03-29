package com.pfa.SOmedical.somedical.Entities;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medecin implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Integer idMedecin;
    private String nomMed;
    private String speciality;
    private String CIN;
    private String mail;
    private String mdp;
    @OneToMany(mappedBy="medecin",fetch=FetchType.LAZY)
    private List<Ordonnance> Ordonnances;


}