package model.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;

import model.entities.Film;
import model.entities.Genre;
import model.entities.Realisateur;

public class DaoFilm extends AbstractDao implements Dao<Film,UUID> {

	@Override
	public void create(Film t) throws DaoException {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
	
	
	@Override
	public void delete(Film t) throws DaoException {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}
	
	@Override
	public void update(Film t) throws DaoException {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}
	
	
	@Override
	public List<Film> readAll() throws DaoException {
//		TypedQuery<Film> q = em.createNamedQuery("READ_ALL_FILM",Film.class);
//		return q.getResultList();

		TypedQuery<Film> q = em.createQuery("select c From Film c",Film.class);
		return q.getResultList();
	}
	
	
	public List<Film> getFilmsByRealisateur(Realisateur realisateur) throws DaoException {

		TypedQuery<Film> q = em.createQuery("select c From Film c Where c.realisateur = :realisateur",Film.class);
		q.setParameter("realisateur", realisateur);
		return q.getResultList();
	}
	
	public List<Film> getFilmsByGenre(Genre genre) throws DaoException {

		TypedQuery<Film> q = em.createQuery("select c From Film c Where c.genre = :genre",Film.class);
		q.setParameter("genre", genre);
		return q.getResultList();
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	
}
