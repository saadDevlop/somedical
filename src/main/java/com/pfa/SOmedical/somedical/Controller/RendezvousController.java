package com.pfa.SOmedical.somedical.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.SOmedical.somedical.DAO.RendezvousRepository;
import com.pfa.SOmedical.somedical.Entities.Rendezvous;
import com.pfa.SOmedical.somedical.Metier.IRendezvousMetier;

@Controller
public class RendezvousController {
	@Autowired
	RendezvousRepository rr;
	@Autowired
	IRendezvousMetier irm;
	
	@GetMapping("/list_rendezvous")
	public String ListerRendezvous(Model model) {
		List<Rendezvous> rdvList = rr.findAll();
		model.addAttribute("ListRendezvous",rdvList);
		return "listRdv";
	}
	
	@GetMapping("/registre_rendezvous")
	public String ajouterRendezvous(Model model) {
		Rendezvous rendezvous = new Rendezvous();
		model.addAttribute("rendezvous" ,rendezvous);
		return "RegRdv";
	}
	
	@PostMapping("/addrdv")
	public String saveRendezvous(@ModelAttribute("rendezvous") @DateTimeFormat(pattern = "yyyy-MM-dd") Rendezvous rdv) {
		rdv.setDescription("En attente");
		irm.saveRendezvous(rdv);
		return "redirect:/list_rendezvous";
	}
	@GetMapping("/delete_rendezvous")
	public String removeRendezvous (Model model ,@RequestParam("ID") Integer id ,@RequestParam("criter")  String mc) {
		rr.deleteById(id);
		return "redirect:/list_rendezvous?criter="+mc;
	
	}
	@RequestMapping(value = { "/update_rendezvous" })
	public String modifierRendezvous(Integer id, Model model) {
		Rendezvous rendezvous = irm.getRendezvousById(id);
		model.addAttribute("Rendezvous", rendezvous);
		return "UpdateRdv";
	}
	
	@RequestMapping(value = { "/detailsrendezvous" })
	public String detailrendezvous(Model model ,Integer id) {
		Rendezvous rendezvous = irm.getRendezvousById(id);
		model.addAttribute("rendezvous", rendezvous);
		return "DetailRdv";
		}
	
	@RequestMapping(value = { "/confirmer_rendezvous" })
	public String confirmerRendezvous(Model model ,@RequestParam("ID") Integer id ,@RequestParam("criter")  String mc) {
		Rendezvous rendezvous = irm.getRendezvousById(id);
		rendezvous.setDescription("Confirmer");
		model.addAttribute("Rendezvous", rendezvous);
		irm.saveRendezvous(rendezvous);
		return "redirect:/list_rendezvous?criter="+mc;
	}

}
