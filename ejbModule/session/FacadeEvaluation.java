package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.entities.Evaluation;
import model.entities.Film;
import model.entities.Genre;
import model.entities.Realisateur;

@Stateless
public class FacadeEvaluation {

	@PersistenceContext
	private EntityManager em;

	
	public List<Evaluation> listerLesEvaluations(){
		TypedQuery<Evaluation> q = em.createQuery("select e From Evaluation e",Evaluation.class);
		return q.getResultList();
	}
	
	
	public void ajouterEvaluation(Evaluation evaluation){
		em.persist(evaluation);
	}
	

	
}
