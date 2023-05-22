package com.pfa.SOmedical.somedical.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;

@Controller
public class RegisterController {
	@Autowired
	MedecinRepository med;
	
	@GetMapping("/register_medecin")
	public String registerMed() {
		return "RegMed";
	}
	
	@GetMapping("/register_infirmier")
	public String registerInf() {
		return "RegInf";
	}
	

}
