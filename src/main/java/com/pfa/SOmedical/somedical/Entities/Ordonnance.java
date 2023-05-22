package com.pfa.SOmedical.somedical.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ordonnance implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Integer idOrd;
    private Date DateOrd;
    @ManyToOne
    @JoinColumn(name="ID_MEDECIN")
    private Medecin medecin;
    @ManyToOne
    @JoinColumn(name="ID_PATIENT")
    private Patient patient;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "ordmedic", joinColumns = { @JoinColumn(name = "idOrd") }, inverseJoinColumns = {
            @JoinColumn(name = "idMedicament") })
    private List<Medicament> medicaments;

}