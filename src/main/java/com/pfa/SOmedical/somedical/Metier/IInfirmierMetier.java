package com.pfa.SOmedical.somedical.Metier;

import java.util.List;

import com.pfa.SOmedical.somedical.Entities.Infirmier;


public interface IInfirmierMetier {

	public Infirmier getInfirmierById(Integer id);
	public void saveInfirmier(Infirmier inf);
	public List<Infirmier> listeInfirmier();
	public void deleteInfirmier(Integer id);

}
