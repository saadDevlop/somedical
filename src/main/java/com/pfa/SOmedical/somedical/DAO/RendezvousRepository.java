package com.pfa.SOmedical.somedical.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.SOmedical.somedical.Entities.Rendezvous;
@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Integer>{

}
