package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pfa.SOmedical.somedical.DAO.DossierMedicalRepository;
import com.pfa.SOmedical.somedical.DAO.PatientRepository;
import com.pfa.SOmedical.somedical.Entities.DossierMedical;
import com.pfa.SOmedical.somedical.Entities.Patient;

@Controller
public class DossierMedicalController {
	@Autowired
	DossierMedicalRepository mr;
	
	@GetMapping("/list_DossierMedical")
	public String ListerPatient(Model model) {
		List<DossierMedical> dmList = mr.findAll();
		model.addAttribute("ListDossierM",dmList);
		return "listdm";
	}

}
