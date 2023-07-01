package com.pfa.SOmedical.somedical.Metier;

import java.util.List;

import com.pfa.SOmedical.somedical.Entities.Medicament;

public interface IMedicamentMetier {
	public Medicament getMedicamentById(Integer id);
	public void saveMedicament(Medicament medic);
	public List<Medicament> listeMedicament();
	public void deleteMedicament(Integer id);
	public List<Medicament> listeMedicamentsById(List<Integer> medicaments);

}
