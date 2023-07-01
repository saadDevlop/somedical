package com.pfa.SOmedical.somedical.Metier;

import java.util.List;

import com.pfa.SOmedical.somedical.Entities.Patient;



public interface IPatientMetier {
	
	public Patient getPatientById(Integer id);
	public void savePatent(Patient pat);
	public List<Patient> listePatient();
	public void deletePatient(Integer id);
}
