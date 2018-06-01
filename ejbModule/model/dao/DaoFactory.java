package model.dao;

import java.util.UUID;

import model.JeuVideo;

public final class DaoFactory {
	
	private  DaoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static  Dao<JeuVideo,UUID> fabriquerDaoJeuVideoJpa() {
		return new DaoFilm();
	}
}
