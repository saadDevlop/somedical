package com.pfa.SOmedical.somedical.metierImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.SOmedical.somedical.DAO.InfirmierRepository;
import com.pfa.SOmedical.somedical.Entities.Infirmier;
import com.pfa.SOmedical.somedical.Metier.IInfirmierMetier;
@Service
@Transactional
public class IInfirmierMetierImp implements IInfirmierMetier{
	@Autowired
	private InfirmierRepository infirmierRepository;
	
	@Override
	public Infirmier getInfirmierById(Integer id) {
		Optional<Infirmier> optional= infirmierRepository.findById(id);
		Infirmier infirmier=null;
		if(optional.isPresent()) {
			infirmier=optional.get();
		}else {
			throw new RuntimeException("Application introuvable pour l'id ::"+id);
		}
		return infirmier;
	}

	@Override
	public void saveInfirmier(Infirmier inf) {
		this.infirmierRepository.save(inf);
		
	}

	@Override
	public List<Infirmier> listeInfirmier() {
		return infirmierRepository.findAll();
	}

	@Override
	public void deleteInfirmier(Integer id) {
		this.infirmierRepository.deleteById(id);
		
	}

}
