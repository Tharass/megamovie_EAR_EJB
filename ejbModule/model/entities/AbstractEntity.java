package model.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// equals/hascode
	
}


