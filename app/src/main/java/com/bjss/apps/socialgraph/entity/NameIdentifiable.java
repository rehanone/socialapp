package com.bjss.apps.socialgraph.entity;

/**
 * Interface to identify any Entity by its name
 * 
 * @author rehan.mahmood
 * 
 * @param <K>
 */
public abstract class NameIdentifiable implements Identifiable<String> {

	public NameIdentifiable() {
	}

	public String getId() {
		return getName();
	}

	abstract public String getName();
}
