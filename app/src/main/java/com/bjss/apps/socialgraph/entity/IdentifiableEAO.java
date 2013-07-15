package com.bjss.apps.socialgraph.entity;

import java.util.List;

/**
 * Interface for Generic Entity Access Object
 * 
 * @author rehan.mahmood
 * 
 * @param <K>
 * @param <E>
 */
public interface IdentifiableEAO<K, E extends Identifiable<K>> {

	/**
	 * @param id
	 * @return EAO
	 */
	public E findById(K id);

	/**
	 * @return list of EAO
	 */
	public List<E> findAll();
}
