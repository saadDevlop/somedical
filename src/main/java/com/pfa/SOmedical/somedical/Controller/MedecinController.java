package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;
import com.pfa.SOmedical.somedical.Entities.Medecin;

@Controller
public class MedecinController {
	@Autowired
	MedecinRepository mr;
	
	@GetMapping("/list_medecin")
	public String ListerMedecin(Model model) {
		List<Medecin> medList = mr.findAll();
		model.addAttribute("ListMedecin",medList);
		return "listMed";
	}

}
