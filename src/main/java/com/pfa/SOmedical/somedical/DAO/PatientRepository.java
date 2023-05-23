package com.pfa.SOmedical.somedical.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.SOmedical.somedical.Entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
