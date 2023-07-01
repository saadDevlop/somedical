package com.pfa.SOmedical.somedical.Controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.SOmedical.somedical.DAO.OrdonnanceRepository;
import com.pfa.SOmedical.somedical.Entities.Infirmier;
import com.pfa.SOmedical.somedical.Entities.Medicament;
import com.pfa.SOmedical.somedical.Entities.Ordonnance;
import com.pfa.SOmedical.somedical.Entities.Patient;
import com.pfa.SOmedical.somedical.Metier.IMedicamentMetier;
import com.pfa.SOmedical.somedical.Metier.IOrdonnanceMetier;
import com.pfa.SOmedical.somedical.Metier.IPatientMetier;

@Controller
public class OrdonnanceController {
	@Autowired
	OrdonnanceRepository or;
	@Autowired
	IOrdonnanceMetier iom;
	@Autowired
	IMedicamentMetier imdm;
	
	@GetMapping("/list_ordonnance")
	public String ListerOrdonnance(Model model) {
		List<Ordonnance> ordList = or.findAll();
		model.addAttribute("ListOrdonnance",ordList);
		return "listOrd";
	}
	@GetMapping("/registre_ordonnance")
	public String ajouterOrdonnance(Model model) {
		Ordonnance ordonnance = new Ordonnance();
		model.addAttribute("ordonnance" ,ordonnance);
		List<Medicament> listM= imdm.listeMedicament();
		model.addAttribute("listM",listM);
		return "RegOrd";
	}
	
	@PostMapping("/addord")
	public String saveOrdonnance(@ModelAttribute("ordonnance") Ordonnance ord,
			@RequestParam(required = false) List<Integer> medicaments) {
		List<Medicament> listMedicaments =new LinkedList<Medicament>();
		listMedicaments.addAll(imdm.listeMedicamentsById(medicaments));
		ord.setMedicaments(listMedicaments);
		iom.saveOrdonnance(ord);
		return "redirect:/list_ordonnance";
	}
	@GetMapping("/delete_ordonnance")
	public String removeOrdonnance(Model model ,@RequestParam("ID") Integer id ,@RequestParam("criter")  String mc) {
		or.deleteById(id);
		return "redirect:/list_ordonnance?criter="+mc;
	
	}
	@RequestMapping(value = { "/update_ordonnance" })
	public String modifierOrdonnance(Integer id, Model model) {
		Ordonnance ordonnance = iom.getOrdonnanceById(id);
		model.addAttribute("ordonnance", ordonnance);
		return "UpdateOrd";
	}
	
	@RequestMapping(value = { "/detailsordonnance" })
	public String detailordonnance(Model model ,Integer id) {
		Ordonnance ordonnance = iom.getOrdonnanceById(id);
		model.addAttribute("ordonnance", ordonnance);
		return "DetailOrd";
		}

}
