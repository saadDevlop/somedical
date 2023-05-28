package com.pfa.SOmedical.somedical.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.SOmedical.somedical.Entities.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Integer>{
	@Query(value = "select m from Medecin m")
	public List<Medecin> listMed();
	@Query(value = "select m from Medecin m where m.nomMed IN (:nomMed)")
	public List<Medecin> listMedByName(@Param("nomMed") List<String> nom);
	
	//@Query(value = "select a from Medecin a where a.nom like '%' || :x || '%'")
	//public List<Medecin> chercher(@Param("x") String mc);

}
