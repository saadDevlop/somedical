package com.pfa.SOmedical.somedical.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfa.SOmedical.somedical.Entities.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
