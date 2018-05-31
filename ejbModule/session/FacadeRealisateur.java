package session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.entities.Personne;
import model.entities.Realisateur;

@Stateless
public class FacadeRealisateur {

	@PersistenceContext
	private EntityManager em;

	
	public void ajouterRealisateur(Realisateur realisateur){
		em.persist(realisateur);
	}

	
	public List<Realisateur> listerLesRealisateurs(){
		TypedQuery<Realisateur> q = em.createQuery("select r From Realisateur r",Realisateur.class);
		return q.getResultList();
	}


	public Map<UUID,Realisateur> mapperLesRealisateurs(){
		Map<UUID, Realisateur> results = new HashMap<UUID, Realisateur>();

		List<Object[]> resultList = em.createQuery("select r.id , r From Realisateur r").getResultList();

		// Place results in map
		for (Object[] borderTypes: resultList) {
			results.put((UUID)borderTypes[0], (Realisateur)borderTypes[1]);
		}
		
		return results;
	}
}
