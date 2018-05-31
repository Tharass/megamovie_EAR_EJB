package model.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@MappedSuperclass
/**
 * Une classe annotée @MappedSuperClass est aussi une classe "persistante",
 *  mais ce ne n'est pas une entité, et à ce titre, on ne peut donc pas faire de requêtes dessus.
 *   Ses champs sont enregistrés en base,
 *  et sont associés aux champs de toutes les entités des sous-classes de cette classe.
 * @author codeur
 *
 */
@EqualsAndHashCode(of="id")
public abstract class AbstractEntity implements Serializable {

	// Champs techniques
	@Id
	@Convert(converter=UUIDConverter.class)
	//@GeneratedUUID
	//Attention utiliser newInstance() de la dao pour faire generer un uuid
	@Column(name="ID",columnDefinition="VARCHAR(36)")
	@Inject
	private UUID id;		
			
	public UUID getId() {
		return id;
	}
	
	public AbstractEntity() {
		this.id=UUID.randomUUID();
	}

}


