package com.pfa.SOmedical.somedical.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pfa.SOmedical.somedical.Entities.Ordonnance;

public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Integer>{

}
