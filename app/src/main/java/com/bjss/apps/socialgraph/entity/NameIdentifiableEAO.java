package com.bjss.apps.socialgraph.entity;

import java.util.List;

/**
 * Interface for Generic Entity Access Object identified by name
 * 
 * @author rehan.mahmood
 * 
 * @param <E>
 */
public abstract class NameIdentifiableEAO<E extends NameIdentifiable> implements IdentifiableEAO<String, E> {

	@Override
	public E findById(final String id) {
		return findByName(id);
	}

	abstract public E findByName(String name);

	@Override
	abstract public List<E> findAll();

	abstract E save(E entity);

	abstract E remove(String name);
}
