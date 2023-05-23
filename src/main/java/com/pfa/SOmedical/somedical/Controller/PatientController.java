package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pfa.SOmedical.somedical.DAO.PatientRepository;
import com.pfa.SOmedical.somedical.Entities.Patient;

@Controller
public class PatientController {
	@Autowired
	PatientRepository mr;
	
	@GetMapping("/list_patient")
	public String ListerPatient(Model model) {
		List<Patient> patList = mr.findAll();
		model.addAttribute("ListPatient",patList);
		return "listPat";
	}
	
}
