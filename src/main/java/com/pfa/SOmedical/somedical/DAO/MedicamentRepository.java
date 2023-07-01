package com.pfa.SOmedical.somedical.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.pfa.SOmedical.somedical.Entities.Medicament;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament,Integer>{
	@Query(value="select i from Medicament i")
	public List<Medicament> listMedic();
 	@Query(value="select i from Medicament i where NomMedicament IN (:nomMedicament)")
 	public List<Medicament> listMedicByName(@Param("nomMedicament") List<String> nom);
 	
 	@Query(value = "select i from Medicament i where i.idMedicament IN (:medicaments)")
 	public List<Medicament> listeMedicamentsById(@Param("medicaments")List<Integer> medicaments);
}
