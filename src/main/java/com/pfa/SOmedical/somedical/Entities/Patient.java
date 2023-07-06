package com.pfa.SOmedical.somedical.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Integer idPatient;
    private String CIN;
    private String Mutuelle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date DateNaissance;
    private String NomPatient;
    private String Mail;
    private String MDP;
    private String Sexe;
    @OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
    private List<Consultation> Consultations;
    @OneToOne(mappedBy = "patient")
    private DossierMedical dossierMedical;
    @OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
    private List<Ordonnance> ordonnances;
    @OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
    private List<Rendezvous> rendezvous;


}