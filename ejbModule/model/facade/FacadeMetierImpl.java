package model.facade;

import java.util.List;
import java.util.UUID;

import model.Evaluation;
import model.JeuVideo;
import model.dao.Dao;
import model.dao.DaoException;
import model.dao.DaoFactory;

public class FacadeMetierImpl implements FacadeMetier {

	Dao<JeuVideo,UUID> persistence = DaoFactory.fabriquerDaoJeuVideoJpa();
	
	
	@Override
	public void ajouterJeuVideo(JeuVideo j) throws BusinessException {
		try {
			persistence.create(j);
		} catch (DaoException e) {
			//je catche la DaoExcepotion pour en lever une autre de bon niveau
			throw new BusinessException(String.format(Messages.CREATION_JEU_IMPOSSIBLE,j.getTitre()));
			
		}
		
	}

	@Override
	public List<JeuVideo> listerJeuxVideos() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return persistence.readAll();
		} catch (DaoException e) {
			//je catche la DaoException pour en lever une autre de bon niveau
			throw new BusinessException(Messages.LISTING_JEUX_IMPOSSIBLE);
		}
	}
	
	
	@Override
	public List<Evaluation> listerEvaluations(JeuVideo jeu) throws BusinessException {
		return null;
//		try {
//			return persistence.readAll();
//		} catch (DaoException e) {
//			//je catche la DaoException pour en lever une autre de bon niveau
//			throw new BusinessException(Messages.LISTING_JEUX_IMPOSSIBLE);
//		}
	}

	@Override
	public void evaluerJeuVideo(JeuVideo j, Evaluation e) throws BusinessException {
		
		try {
			j.ajouterEvaluation(e);
			persistence.update(j);
		} catch (DaoException e1) {
			//je catche la DaoException pour en lever une autre de bon niveau
			throw new BusinessException(String.format(Messages.EVALUATION_JEU_IMPOSSIBLE,j.getTitre()));
		}
	}

	@Override
	public void supprimerJeuVideo(JeuVideo j) throws BusinessException {
		try {
			persistence.delete(j);
		} catch (DaoException e) {
			//je catche la DaoExcepotion pour en lever une autre de bon niveau
			throw new BusinessException(String.format(Messages.SUPRESSION_JEU_IMPOSSIBLE,j.getTitre()));
			
		}
		
	}

}
