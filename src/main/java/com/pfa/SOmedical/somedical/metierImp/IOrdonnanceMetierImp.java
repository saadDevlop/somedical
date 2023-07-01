package com.pfa.SOmedical.somedical.metierImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pfa.SOmedical.somedical.DAO.OrdonnanceRepository;
import com.pfa.SOmedical.somedical.Entities.Ordonnance;
import com.pfa.SOmedical.somedical.Metier.IOrdonnanceMetier;
@Service
@Transactional
public class IOrdonnanceMetierImp implements IOrdonnanceMetier{
	@Autowired
	private OrdonnanceRepository ordonnanceRepository;
	
	@Override
	public Ordonnance getOrdonnanceById(Integer id) {
		Optional<Ordonnance> optional= ordonnanceRepository.findById(id);
		Ordonnance ordonnance=null;
		if(optional.isPresent()) {
			ordonnance=optional.get();
		}else {
			throw new RuntimeException("Application introuvable pour l'id ::"+id);
		}
		return ordonnance;
	}

	@Override
	public void saveOrdonnance(Ordonnance ord) {
		this.ordonnanceRepository.save(ord);
		
	}

	@Override
	public List<Ordonnance> listeOrdonnance() {
		return ordonnanceRepository.findAll();
	}

	@Override
	public void deleteOrdonnance(Integer id) {
		this.ordonnanceRepository.deleteById(id);
		
	}

}
