package com.pfa.SOmedical.somedical.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pfa.SOmedical.somedical.Entities.Rendezvous;
@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Integer>{
	@Query(value="select i from Rendezvous i")
	public List<Rendezvous> listRdv();

}
