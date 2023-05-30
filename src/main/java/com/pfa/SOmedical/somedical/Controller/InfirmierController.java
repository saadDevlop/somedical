package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.SOmedical.somedical.DAO.InfirmierRepository;
import com.pfa.SOmedical.somedical.Entities.Infirmier;
import com.pfa.SOmedical.somedical.Entities.Medecin;
import com.pfa.SOmedical.somedical.Metier.IInfirmierMetier;


@Controller
public class InfirmierController {
	@Autowired
	InfirmierRepository ir;
	@Autowired
	IInfirmierMetier iim;
	
	@GetMapping("/list_infirmier")
	public String ListerInfirmier(Model model) {
		List<Infirmier> infList = ir.findAll();
		model.addAttribute("ListInfirmier",infList);
		return "listInf";
	}
	
	@GetMapping("/registre_infirmier")
	public String ajouterInfirmier(Model model) {
		Infirmier infirmier = new Infirmier();
		model.addAttribute("infirmier" ,infirmier);
		return "RegInf";
	}
	
	@PostMapping("/addinf")
	public String saveInfirmier(@ModelAttribute("infirmier") Infirmier inf) {
		iim.saveInfirmier(inf);
		return "redirect:/list_infirmier";
	}
	@GetMapping("/delete_infirmier")
	public String removeInfirmier (Model model ,@RequestParam("ID") Integer id ,@RequestParam("criter")  String mc) {
		ir.deleteById(id);
		return "redirect:/list_infirmier?criter="+mc;
	
	}
	@RequestMapping(value = { "/update_infirmier" })
	public String modifierInfirmier(Integer id, Model model) {
		Infirmier infirmier = iim.getInfirmierById(id);
		model.addAttribute("infirmier", infirmier);
		return "UpdateInf";
	}
}
