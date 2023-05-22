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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rendezvous implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idRen;
    private Date DateRenderVous;
    private String TypeMaladie;
    private String Description;
    @ManyToOne
    @JoinColumn(name="ID_PATIENT")
    private Patient patient;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "rendezvous")
    private List<Infirmier> Infermiers;

}