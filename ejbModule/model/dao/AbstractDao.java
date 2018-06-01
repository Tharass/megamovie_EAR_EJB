package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao {
	
	@PersistenceContext
	protected EntityManager em;
}
