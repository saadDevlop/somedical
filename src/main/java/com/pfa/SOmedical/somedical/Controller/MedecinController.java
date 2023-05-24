package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;
import com.pfa.SOmedical.somedical.Entities.Medecin;

import org.springframework.validation.BindingResult;

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
	@GetMapping("/delete_medecin")
	public String removeMedecin (Model model ,@RequestParam("ID") Integer id ,@RequestParam("criter")  String mc) {
		mr.deleteById(id);
		return "redirect:/list_medecin?criter="+mc;
	}
	
	@GetMapping("/registre_medecin")
	public String ajouterMedecin(Model model) {
		Medecin m =new Medecin();
		model.addAttribute("med" ,m);
		return "RegMed";
	}
	@PostMapping("/addmed")
	public String saveMedecin(Model model , Medecin med ) {
		mr.save(med);
		return"redirect:/listMed";
		
	}

}
