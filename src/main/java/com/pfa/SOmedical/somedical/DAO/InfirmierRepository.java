package com.pfa.SOmedical.somedical.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.SOmedical.somedical.Entities.Infirmier;
@Repository
public interface InfirmierRepository extends JpaRepository <Infirmier, Integer>{
 	@Query(value="select i from Infirmier i")
	public List<Infirmier> listInf();
 	@Query(value="select i from Infirmier i where NomInf IN (:nomInf)")
 	public List<Infirmier> listInfByName(@Param("nomInf") List<String> nom);


}
