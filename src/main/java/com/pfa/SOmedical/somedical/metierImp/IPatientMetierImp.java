package com.pfa.SOmedical.somedical.metierImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.SOmedical.somedical.DAO.PatientRepository;
import com.pfa.SOmedical.somedical.Entities.Patient;
import com.pfa.SOmedical.somedical.Metier.IPatientMetier;
@Service
@Transactional
public class IPatientMetierImp implements IPatientMetier{
	@Autowired
	private PatientRepository patientRepository;
	@Override
	public Patient getPatientById(Integer id) {
		Optional<Patient> optional= patientRepository.findById(id);
		Patient patient=null;
		if(optional.isPresent()) {
			patient=optional.get();
		}else {
			throw new RuntimeException("Application introuvable pour l'id ::"+id);
		}
		return patient;
	}

	@Override
	public void savePatent(Patient pat) {
		this.patientRepository.save(pat);
		
	}

	@Override
	public List<Patient> listePatient() {
		return patientRepository.findAll();
	}

	@Override
	public void deletePatient(Integer id) {
		this.patientRepository.deleteById(id);
		
	}

}
