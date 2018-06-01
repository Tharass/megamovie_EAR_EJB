package session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.dao.Dao;
import model.dao.DaoException;
import model.dao.DaoFilm;
import model.entities.Film;
import model.entities.Genre;
import model.entities.Realisateur;
import model.facade.BusinessException;


@Stateless
public class FacadeFilm {
	
	//TODO rattaché ???
	private DaoFilm persistence;

	
	
	public List<Film> listerLesFilms() throws BusinessException{
		try {
			return persistence.readAll();
		} catch (DaoException e) {
			//je catche la DaoException pour en lever une autre de bon niveau
			throw new BusinessException(Messages.LISTING_FILM_IMPOSSIBLE);
		}
		
	}
	
	public List<Film> listerLesFilmsParRealisateur(Realisateur realisateur) throws BusinessException{
		try {
			return persistence.getFilmsByRealisateur(realisateur);
		} catch (DaoException e) {
			//je catche la DaoException pour en lever une autre de bon niveau
			throw new BusinessException(String.format(Messages.LISTING_FILM_IMPOSSIBLE_PAR_REALISATEUR,realisateur.getNom()));
		}
	}
	
	public List<Film> listerLesFilmsParGenre(Genre genre){
		try {
			return persistence.getFilmsByGenre(genre);
		} catch (DaoException e) {
			//je catche la DaoException pour en lever une autre de bon niveau
			throw new BusinessException(String.format(Messages.LISTING_FILM_IMPOSSIBLE_PAR_REALISATEUR,genre.toString()));
		}
	}
	
	public Map<Genre, Long> compterLesFilmsParGenre(){

		Map<Genre, Long> results = new HashMap();

		List<Object[]> resultList = em.createQuery("select f.genre , count(f.id) From Film f Group By f.genre").getResultList();

		// Place results in map
		for (Object[] borderTypes: resultList) {
			results.put((Genre)borderTypes[0], (Long)borderTypes[1]);
		}
		return results;
	}

	public List<Film> chercherFilm(String titre){

		TypedQuery<Film> q = em.createQuery("select c From Film c WHERE c.titre LIKE :titre",Film.class);
		q.setParameter("titre", titre);
		return q.getResultList();
	}
	
	public void ajouterFilm(Film film) throws BusinessException{
		try {
			persistence.create(film);
		} catch (DaoException e) {
			//je catche la DaoExcepotion pour en lever une autre de bon niveau
			throw new BusinessException(String.format(Messages.CREATION_FILM_IMPOSSIBLE,film.getTitre()));
			
		}
	}
	
	public void supprimerFilm(Film film) throws BusinessException {
		try {
			persistence.delete(film);
		} catch (DaoException e) {
			//je catche la DaoExcepotion pour en lever une autre de bon niveau
			throw new BusinessException(String.format(Messages.SUPRESSION_FILM_IMPOSSIBLE,film.getTitre()));
			
		}
	}
	
	
	public void modifierFilm(Film film)throws BusinessException {
		try {
			persistence.update(film);
		} catch (DaoException e) {
			//je catche la DaoException pour en lever une autre de bon niveau
			throw new BusinessException(String.format(Messages.MAJ_FILM_IMPOSSIBLE,film.getTitre()));
		}
	}
	
	

	
	
}
