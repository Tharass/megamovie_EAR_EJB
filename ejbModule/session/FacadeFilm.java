package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.entities.Film;
import model.entities.Genre;
import model.entities.Realisateur;

@Stateless
public class FacadeFilm {

	@PersistenceContext
	private EntityManager em;

	public List<Film> listerLesFilms(){

		TypedQuery<Film> q = em.createQuery("select c From Film c",Film.class);
		return q.getResultList();
	}
	
	public List<Film> listerLesFilmsParRealisateur(Realisateur realisateur){

		TypedQuery<Film> q = em.createQuery("select c From Film c Where c.realisateur = :realisateur",Film.class);
		q.setParameter("realisateur", realisateur);
		return q.getResultList();
	}
	
	public List<Film> listerLesFilmsParGenre(Genre genre){

		TypedQuery<Film> q = em.createQuery("select c From Film c Where c.genre = :genre",Film.class);
		q.setParameter("genre", genre);
		return q.getResultList();
	}

	public List<Film> chercherFilm(String titre){

		TypedQuery<Film> q = em.createQuery("select c From Film c WHERE c.titre LIKE :titre",Film.class);
		q.setParameter("titre", titre);
		return q.getResultList();
	}
	
	public void ajouterFilm(Film film){
		em.persist(film);
	}
	
	public void supprimerFilm(Film film){
//		System.out.println(film.getId());
//		TypedQuery<Film> q = em.createQuery("select c From Film c WHERE c.id = :id",Film.class);
//		q.setParameter("id", film.getId());
//		List<Film> per = q.getResultList();
//		
//		
//		em.remove(per.get(0));
		if ( !em.contains(film) ) {
			film = em.merge(film);
		}
		em.remove(film);
	}
	
	public void supprimerAll(){
		
		TypedQuery<Film> q = em.createQuery("select c From Film c ",Film.class);
		
		List<Film> per = q.getResultList();
		
		for (Film p : per) {
			em.remove(p);
		}
		
	}
	
	public void modifierFilm(Film Film){
		em.merge(Film);
	}
	
}
