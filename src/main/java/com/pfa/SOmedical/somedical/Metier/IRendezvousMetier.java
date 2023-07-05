package com.pfa.SOmedical.somedical.Metier;

import java.util.List;

import com.pfa.SOmedical.somedical.Entities.Rendezvous;

public interface IRendezvousMetier {
	public Rendezvous getRendezvousById(Integer id);
	public void saveRendezvous(Rendezvous rdv);
	public List<Rendezvous> listeRendezvous();
	public void deleteRendezvous(Integer id);

}
