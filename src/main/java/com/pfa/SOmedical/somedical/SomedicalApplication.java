package com.pfa.SOmedical.somedical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import com.pfa.SOmedical.somedical.DAO.MedecinRepository;
import com.pfa.SOmedical.somedical.Entities.Medecin;

@SpringBootApplication

public class SomedicalApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=	SpringApplication.run(SomedicalApplication.class, args);
		MedecinRepository med= ctx.getBean(MedecinRepository.class);
		//med.save(new Medecin(null,"oumaima", "generaliste", "A12345", "oumaima@gmail.com", "ouma123", null));
		med.save(new Medecin(null,"Yasmine", "cardiologe", "GI11463", "yasmine@gmail.com", "yasmine123", null));
	}

}
