package com.pfa.SOmedical.somedical.metierImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.SOmedical.somedical.DAO.MedicamentRepository;
import com.pfa.SOmedical.somedical.Entities.Medicament;
import com.pfa.SOmedical.somedical.Metier.IMedicamentMetier;

@Service
@Transactional
public class IMedicamentMetierImp implements IMedicamentMetier{
	@Autowired
	private MedicamentRepository medicamentRepository;

	@Override
	public Medicament getMedicamentById(Integer id) {
		Optional<Medicament> optional= medicamentRepository.findById(id);
		Medicament medicament=null;
		if(optional.isPresent()) {
			medicament=optional.get();
		}else {
			throw new RuntimeException("Application introuvable pour l'id ::"+id);
		}
		return medicament;
	}

	@Override
	public void saveMedicament(Medicament medic) {
		this.medicamentRepository.save(medic);
		
	}

	@Override
	public List<Medicament> listeMedicament() {
		return medicamentRepository.findAll();
	}

	@Override
	public void deleteMedicament(Integer id) {
		this.medicamentRepository.deleteById(id);
		
	}

	@Override
	public List<Medicament> listeMedicamentsById(List<Integer> medicaments) {
		return medicamentRepository.listeMedicamentsById(medicaments);
	}

}
