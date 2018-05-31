package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
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
@Table(name="REALISATEUR")
public class Realisateur extends AbstractEntity  implements Serializable{


	
	@NotEmpty(message="le champs ne doit pas être vide")
	String nom;

	
	
	@NotEmpty(message="le champs ne doit pas être vide")
	String prenom;

	
	@Override
	public String toString() {
		return String.format("%s %s", this.nom,this.prenom);
	}


	public Realisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}


}
