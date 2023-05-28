package com.pfa.SOmedical.somedical.Metier;

import java.util.List;

import com.pfa.SOmedical.somedical.Entities.Medecin;


public interface IMedecinMetier {
	public Medecin getMedecinById(Integer id);
	public List<Medecin> listeMedecin();
	public void saveMedecin(Medecin medecin);
	public void deleteMedecin(Integer id);
	//public List<Medecin> chercher(String mc);

}
