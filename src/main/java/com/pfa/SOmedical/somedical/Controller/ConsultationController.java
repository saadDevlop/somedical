package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pfa.SOmedical.somedical.DAO.ConsultationRepository;
import com.pfa.SOmedical.somedical.Entities.Consultation;

@Controller
public class ConsultationController {
	@Autowired
	ConsultationRepository mr;
	
	@GetMapping("/list_consultation")
	public String ListerConsultation(Model model) {
		List<Consultation> consList = mr.findAll();
		model.addAttribute("ListConsultation",consList);
		return "listCons";
	}

}
