package com.pfa.SOmedical.somedical.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;
import com.pfa.SOmedical.somedical.Entities.Medecin;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@Autowired
	
	
	@GetMapping("/login")
	public String login() {
		return"login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 public ModelAndView loginMed() {
		 ModelAndView mav = new ModelAndView("login");
		 mav.addObject("medecin", new Medecin());
		 return mav;
	}
	@PostMapping("/login")
	public String loginMed(@ModelAttribute("medecin") Medecin medecin) {
		Medecin authmed = ms.loginMed(medecin.getMail(), medecin.getMdp());
		System.out.println(authmed);
		
		if(Objects.nonNull(authmed)) {
			return "redirect:/RegMed";
		}else {
			return "login";
		}
	}
	*/



}
