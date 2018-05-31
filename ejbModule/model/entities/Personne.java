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
@EqualsAndHashCode(of="id")
//CDI
@Dependent
//JPA
@Entity
@Table(name="PERSONNE")
public class Personne extends AbstractEntity  implements Serializable{


	@Getter @Setter
	@Column(columnDefinition="VARCHAR(30)")
	@Length(min=1,max=8)
	@NotEmpty(message="le champs ne doit pas être vide")
	String login;

	@Getter @Setter
	@Column(columnDefinition="VARCHAR(30)")
	@Length(min=1,max=8)
	@NotEmpty(message="le champs ne doit pas être vide")
	String mdp;

	public Personne(String login, String mdp) {
		this.login = login;
		this.mdp = mdp;
	}


	


}
