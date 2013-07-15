package com.bjss.apps.socialgraph.entity;

/**
 * Interface to identify any Entity by its id
 * 
 * @author rehan.mahmood
 * 
 * @param <K>
 */
public interface Identifiable<K> {

	/**
	 * @return id
	 */
	K getId();
}
