package model.commons;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class GlobalFactory {
	
	@Produces
	public static UUID createUUID() {
		return UUID.randomUUID();
	}
	
}
