package com.pfa.SOmedical.somedical.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfa.SOmedical.somedical.Entities.Medecin;
@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Integer>{
	
	//Medecin findMedBymail(String mail ,String pass);

}
