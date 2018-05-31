package model.entities;

import java.time.LocalDate;

import model.entities.Film;
import model.entities.Realisateur;

public final class FilmFactory {

	
	private FilmFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Film fabriquerFilm(String titre, Genre genre, LocalDate dateSortie, Realisateur realisateur) {
		// TODO Auto-generated method stub
		return new Film(titre, genre, dateSortie, realisateur);
	}
	
	
}
