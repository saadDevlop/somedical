package com.pfa.SOmedical.somedical.Metier;

import com.pfa.SOmedical.somedical.Entities.Infirmier;

public interface IInfirmierMetier {

	public Infirmier getInfirmierById(Integer id);
	public void saveInfirmier(Infirmier inf);

}
