package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.pfa.SOmedical.somedical.DAO.InfirmierRepository;
import com.pfa.SOmedical.somedical.Entities.Infirmier;


@Controller
public class InfirmierController {
	@Autowired
	InfirmierRepository mr;
	
	@GetMapping("/list_infirmier")
	public String ListerInfirmier(Model model) {
		List<Infirmier> infList = mr.findAll();
		model.addAttribute("ListMedecin",infList);
		return "listInf";
	}
}
