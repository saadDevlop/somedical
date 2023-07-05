package com.pfa.SOmedical.somedical.metierImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.SOmedical.somedical.DAO.RendezvousRepository;
import com.pfa.SOmedical.somedical.Entities.Rendezvous;
import com.pfa.SOmedical.somedical.Metier.IRendezvousMetier;
@Service
@Transactional
public class IRendezvousMetierImp implements IRendezvousMetier{
	@Autowired
	private RendezvousRepository rendezvousRepository;

	@Override
	public Rendezvous getRendezvousById(Integer id) {
		Optional<Rendezvous> optional= rendezvousRepository.findById(id);
		Rendezvous rendezvous=null;
		if(optional.isPresent()) {
			rendezvous=optional.get();
		}else {
			throw new RuntimeException("Application introuvable pour l'id ::"+id);
		}
		return rendezvous;
	}

	@Override
	public void saveRendezvous(Rendezvous rdv) {
		this.rendezvousRepository.save(rdv);
		
	}

	@Override
	public List<Rendezvous> listeRendezvous() {
		return rendezvousRepository.findAll();
	}

	@Override
	public void deleteRendezvous(Integer id) {
		this.rendezvousRepository.deleteById(id);
		
	}

}
