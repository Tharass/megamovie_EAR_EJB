package model.init;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import model.entities.Personne;
import model.entities.Realisateur;
import session.FacadePersonne;
import session.FacadeRealisateur;

@Singleton
@Startup
public class MonSingleton {

		
	@Inject
	FacadePersonne fper;
	@Inject
	FacadeRealisateur fReal;
	
	@PostConstruct
	public void init() {
		//Si aucun realisateur Insere des realisateurs
		if (fReal.listerLesRealisateurs().isEmpty()) {
			Realisateur dorcel = CDI.current().select(Realisateur.class).get();
			Realisateur spielberg = CDI.current().select(Realisateur.class).get();
			Realisateur lucas = CDI.current().select(Realisateur.class).get();
			
			dorcel.setNom("Dorcel");
			dorcel.setPrenom("Marc");
			
			spielberg.setNom("Spielberg");
			spielberg.setPrenom("Steven");
			
			lucas.setNom("Lucas");
			lucas.setPrenom("George");
			
			fReal.ajouterRealisateur(dorcel);
			fReal.ajouterRealisateur(spielberg);
			fReal.ajouterRealisateur(lucas);
		}
		
		// Si aucune personne Insere une personne
		if (fper.isEmptyPersonne()) {
			Personne john = CDI.current().select(Personne.class).get();
			john.setLogin("john");
			john.setMdp("john");
			fper.ajouterPersonne(john);
		}
	
		
		System.out.println("Debut Server");
	}
	
	
}
