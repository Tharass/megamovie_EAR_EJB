package model.JPA;

import java.util.UUID;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class UUIDConverter implements AttributeConverter<UUID, String> {

	@Override
	public String convertToDatabaseColumn(UUID id) {
		return id.toString();
	}

	@Override
	public UUID convertToEntityAttribute(String id) {
		return UUID.fromString(id);
	}

}
