package com.pfa.SOmedical.somedical.Entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private List<Ordonnance> Ordonnances;


}
