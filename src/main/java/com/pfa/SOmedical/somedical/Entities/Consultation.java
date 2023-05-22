package com.pfa.SOmedical.somedical.Entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Consultation implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idConsult;
    private double PrixVisite;
    private String Motif;
    private Date DateConsult;
    @ManyToOne
    @JoinColumn(name="ID_PATIENT")
    private Patient patient;
}