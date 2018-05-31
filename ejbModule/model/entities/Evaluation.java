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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name="EVALUATION")
public class Evaluation extends AbstractEntity implements Serializable{


	
	Integer note;
	
	String commentaire;	


}
