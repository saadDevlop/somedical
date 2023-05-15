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
	private List<Rendezvous> rendezvous;
}
