package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import model.entities.converter.LocalDateConverter;

@SuppressWarnings("serial")
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
//CDI
@Dependent
//JPA
@Entity
@Table(name="FILM")
public class Film extends AbstractEntity implements Serializable{


	
//	@NotEmpty(message="le champs ne doit pas être vide")
	String titre;
	
	@ManyToOne
//	@NotEmpty(message="le champs ne doit pas être vide")
	Realisateur realisateur;
	
	@Convert(converter = LocalDateConverter.class)
	LocalDate dateDeSortie;
	
	@Enumerated(EnumType.STRING)
	Genre genre;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
            name="FILM_EVALUATIONS",
            joinColumns = @JoinColumn(name="FILM_ID", referencedColumnName="ID") ,
            inverseJoinColumns =  @JoinColumn(name="EVALUATION_ID", referencedColumnName="ID", unique=true))
	List<Evaluation> evaluations;
	
	@Lob
    private byte[] jacket;	
	
	
	/**
	 * Getteur du GENRE ( enumeration )
	 * @return
	 */
	public String getGenre() {
		if (genre != null) {
			return genre.toString();
		}else {
			return "";
		}		
	}

	/** 
	 * Setteur du GENRE ( enumeration
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = Genre.valueOf(genre);
	}

	
	public Film(String titre, Genre genre, LocalDate dateSortie, Realisateur realisateur) {
		this.titre = titre;
		this.genre = genre;
		this.dateDeSortie = dateSortie;
		this.realisateur = realisateur;
	}
	
	public void ajouterEvaluation(Evaluation eval) {
		if (evaluations != null) {
			evaluations.add(eval);
		}		
	}


}
