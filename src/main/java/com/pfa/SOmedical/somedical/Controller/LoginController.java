package com.pfa.SOmedical.somedical.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;
import com.pfa.SOmedical.somedical.Entities.Medecin;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@Autowired
	MedecinRepository med;
	
	@GetMapping("/login")
	public String login(Model model) {
		 model.addAttribute("medecin", new Medecin());
	        return "login";
	
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("medecin") Medecin medecin, BindingResult bindingResult, HttpServletRequest request) {
		return "";
	}
	



}
