package com.pfa.SOmedical.somedical.Metier;

import java.util.List;

import com.pfa.SOmedical.somedical.Entities.Ordonnance;

public interface IOrdonnanceMetier {
	public Ordonnance getOrdonnanceById(Integer id);
	public void saveOrdonnance(Ordonnance ord);
	public List<Ordonnance> listeOrdonnance();
	public void deleteOrdonnance(Integer id);
}
