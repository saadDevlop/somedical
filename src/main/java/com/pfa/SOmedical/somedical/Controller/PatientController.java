package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.SOmedical.somedical.DAO.PatientRepository;
import com.pfa.SOmedical.somedical.Entities.Patient;
import com.pfa.SOmedical.somedical.Metier.IPatientMetier;

@Controller

public class PatientController {
	@Autowired
	PatientRepository pr;
	
	@Autowired
	IPatientMetier ipm;
	
	@GetMapping("/list_patient")
	public String ListerPatient(Model model) {
		List<Patient> patList = pr.findAll();
		model.addAttribute("ListPatient",patList);
		return "listPat";
	}
	
	@GetMapping("/registre_patient")
	public String ajouterPatient(Model model) {
		Patient patient = new Patient();
		model.addAttribute("patient" ,patient);
		return "RegPat";
	}
	
	@PostMapping("/addpat")
	public String savePatient(@ModelAttribute("patient") @DateTimeFormat(pattern = "yyyy-MM-dd") Patient pat) {
		ipm.savePatent(pat);
		return "redirect:/list_patient";
	}
	

	@GetMapping("/delete_patient")
	public String removePatient (Model model ,@RequestParam("ID") Integer id ,@RequestParam("criter")  String mc) {
		pr.deleteById(id);
		return "redirect:/list_patient?criter="+mc;
	}
	
	@RequestMapping(value = { "/detailspatient" })
	public String detailpatient(Model model ,Integer id) {
		Patient patient = ipm.getPatientById(id);
		model.addAttribute("patient", patient);
		return "DetailPat";
		}
	

	
	
}
