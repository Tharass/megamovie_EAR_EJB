package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.entities.Film;
import model.entities.Personne;

@Stateless
public class FacadePersonne {

	@PersistenceContext
	private EntityManager em;

	public void ajouterPersonne(Personne personne){
		em.persist(personne);
	}

	public boolean testerConnection(String login, String mdp){
		TypedQuery<Long> q = 
				em.createQuery("SELECT COUNT(p.login) FROM Personne p WHERE p.login = :login AND p.mdp = :mdp",Long.class);
		q.setParameter("login", login);
		q.setParameter("mdp", mdp);
		return (q.getSingleResult() > 0);
	}

	public boolean isEmptyPersonne(){
		TypedQuery<Long> q = 
				em.createQuery("SELECT COUNT(p.login) FROM Personne p ",Long.class);
		return (q.getSingleResult() < 1);
	}
}
