package com.pfa.SOmedical.somedical.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.SOmedical.somedical.Entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	@Query(value="select p from Patient p")
	public List<Patient> listPat();
	@Query(value="select p from Patient p where NomPatient IN (:nomPat)")
	public List<Patient> listPatByName(@Param("nomPat") List<String> nom);
	//@Query(value = "select p from Patient p where CIN IN (:cinPat)")
	//public List<Patient> listPatByCin(@Param("cinPat") List<String> cin);

}
