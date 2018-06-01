package model.facade;

import java.util.List;

import model.Evaluation;
import model.JeuVideo;

public interface FacadeMetier {

	/**
	 * Fontionnalité 1: créer un jeu video en base de données
	 * 
	 * @param j
	 * @throws BusinessException 
	 */
	void ajouterJeuVideo(JeuVideo j) throws BusinessException;	
	
	
	/**
	 * Fontionnalité click droit: supprimer un jeu video en base de données
	 * 
	 * @param j
	 * @throws BusinessException 
	 */
	void supprimerJeuVideo(JeuVideo j) throws BusinessException;	
	
	/**
	 * Fonctionnalité 2 : recuperer les jeux videos de la bdd pour alimenter le tableView d'EcranPrincipal
	 * @return
	 * @throws BusinessException 
	 */
	List<JeuVideo> listerJeuxVideos() throws BusinessException;
	
	/**
	 * Fonctionnalité 3  : ajouter l'evaluation e au jeuVideo j
	 * Demander l'update de j
	 * @param j:  JeuVideo évalué
	 * @param e: Evaluation saisie dans l'écran EcranEvaluation.fxml
	 */
	void evaluerJeuVideo(JeuVideo j, Evaluation e) throws BusinessException;


	/**
	 * Lister les evaluations pour un jeu video
	 * @param jeu
	 * @return
	 * @throws BusinessException
	 */
	List<Evaluation> listerEvaluations(JeuVideo jeu) throws BusinessException;
}
