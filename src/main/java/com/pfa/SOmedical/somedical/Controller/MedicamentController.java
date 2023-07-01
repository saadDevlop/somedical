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

import com.pfa.SOmedical.somedical.DAO.MedicamentRepository;
import com.pfa.SOmedical.somedical.Entities.Medicament;
import com.pfa.SOmedical.somedical.Metier.IMedicamentMetier;

@Controller
public class MedicamentController {
	@Autowired
	MedicamentRepository mr;
	@Autowired
	IMedicamentMetier imdm;
	
	@GetMapping("/list_medicament")
	public String ListerMedicament(Model model) {
		List<Medicament> medList = mr.findAll();
		model.addAttribute("ListMedicament",medList);
		return "listMedic";
	}
	
	@GetMapping("/registre_medicament")
	public String ajouterMedicament(Model model) {
		Medicament medicament = new Medicament();
		model.addAttribute("medicament" ,medicament);
		return "RegMedic";
	}
	
	@PostMapping("/addmedic")
	public String saveMedicament(@ModelAttribute("medicament") Medicament medic) {
		imdm.saveMedicament(medic);
		return "redirect:/list_medicament";
	}
	@GetMapping("/delete_medicament")
	public String removeMedicament (Model model ,@RequestParam("ID") Integer id ,@RequestParam("criter")  String mc) {
		mr.deleteById(id);
		return "redirect:/list_medicament?criter="+mc;
	
	}
	@RequestMapping(value = { "/update_medicament" })
	public String modifierMedicament(Integer id, Model model) {
		Medicament medicament = imdm.getMedicamentById(id);
		model.addAttribute("medicament", medicament);
		return "UpdateMedic";
	}
	
	@RequestMapping(value = { "/detailsmedicament" })
	public String detailmedicament(Model model ,Integer id) {
		Medicament medicament = imdm.getMedicamentById(id);
		model.addAttribute("medicament", medicament);
		return "DetailMedic";
		}
}
