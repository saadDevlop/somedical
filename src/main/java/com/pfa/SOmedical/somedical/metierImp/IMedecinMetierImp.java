package com.pfa.SOmedical.somedical.metierImp;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;
import com.pfa.SOmedical.somedical.Entities.Medecin;
import com.pfa.SOmedical.somedical.Metier.IMedecinMetier;



@Service
@Transactional

public class IMedecinMetierImp implements IMedecinMetier{
	@Autowired
	private MedecinRepository medecinRepository;

	@Override
	public Medecin getMedecinById(Integer id) {
		Optional<Medecin> optional= medecinRepository.findById(id);
		Medecin medecin=null;
		if(optional.isPresent()) {
			medecin=optional.get();
		}else {
			throw new RuntimeException("Application introuvable pour l'id ::"+id);
		}
		return medecin;
	}

	@Override
	public List<Medecin> listeMedecin() {
		return medecinRepository.findAll();
	}

	@Override
	public void saveMedecin(Medecin medecin) {
		this.medecinRepository.save(medecin);
	}

	@Override
	public void deleteMedecin(Integer id) {
		this.medecinRepository.deleteById(id);
		
	}

	

	//@Override
	//public List<Medecin> chercher(String mc) {
		//return medecinRepository.chercher(mc);
	//}

}
