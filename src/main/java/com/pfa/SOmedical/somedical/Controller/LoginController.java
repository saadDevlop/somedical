package com.pfa.SOmedical.somedical.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;
import com.pfa.SOmedical.somedical.Entities.Medecin;
import com.pfa.SOmedical.somedical.Entities.Patient;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
public class LoginController {
	
	
	

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody Patient loginRequest){
		   if (isValidCredentials(loginRequest.getMail(),loginRequest.getMDP())) {
	            String token = generateToken(loginRequest.getNomPatient());
	            return ResponseEntity.ok("success");

		   }else {
			   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		   }
		   
		
	}

  
  private String generateToken(String patname) {
      // Generate and return a token for the authenticated user
      // You can use libraries like JWT to generate a token
      // For simplicity, let's return a plain string token
	  return "your_token_here";
  }
	
	
	
	private boolean isValidCredentials(String mail, String password) {
     
        return mail.equals("admin") && password.equals("password");
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
