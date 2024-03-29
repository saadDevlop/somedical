package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;
import com.pfa.SOmedical.somedical.Entities.Medecin;
import com.pfa.SOmedical.somedical.Metier.IMedecinMetier;
import com.pfa.SOmedical.somedical.metierImp.IMedecinMetierImp;

import org.springframework.validation.BindingResult;
//toutes les fonctions qui s'appliquent sur le medecins
@Controller
public class MedecinController {
	@Autowired
	MedecinRepository mr;
	
	@Autowired
	IMedecinMetier imm;
	@Autowired
	IMedecinMetierImp immi;
	
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
		Medecin medecin =new Medecin();
		model.addAttribute("medecin" ,medecin);
		return "RegMed";
	}
	@PostMapping("/addmed")
	public String saveMedecin(@ModelAttribute("medecin") Medecin med ) {
		imm.saveMedecin(med);
		return"redirect:/list_medecin";	
	}
	@RequestMapping(value = { "/update_medecin" })
	public String modifierMedecin(Integer id, Model model) {
		Medecin medecin = imm.getMedecinById(id);
		model.addAttribute("medecin", medecin);
		return "UpdateMed ";
	}
	
	@RequestMapping(value = { "/detailsmedecin" })
	public String detailmedecin(Model model ,Integer id) {
		Medecin med = imm.getMedecinById(id);
		model.addAttribute("medecin",med);
		return "DetailMed";
		}
	
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

	 @PostMapping("/login")
	    public String login(@RequestBody @ModelAttribute("medecin") Medecin loginForm, Model model) {
	        String mail = loginForm.getMail();
	        String password = loginForm.getMdp();
	        System.out.println(mail);
	        System.out.println(password);

	        if (immi.validateCredentials(mail, password)) {
	            // Authentication successful, proceed with further logic
	            return "redirect:/index";
	        } else {
	            // Authentication failed, display error message
	            model.addAttribute("error", "Invalid username or password");
	            return "login";
	        }
	    }
}
