package com.bjss.apps.socialgraph.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.bjss.apps.socialgraph.person.Person;

/**
 * Provides in-memory implementation for person data storage. This class implemented as a singleton.
 * 
 * @author rehan
 * 
 */
public class CacheingPersonEAO extends NameIdentifiableEAO<Person> {

	private final Map<String, Person> data = new HashMap<String, Person>();

	private static CacheingPersonEAO inst = new CacheingPersonEAO();

	/**
	 * Singleton constructor
	 */
	private CacheingPersonEAO() {
		// nfy
	}

	/**
	 * Singleton instance provider.
	 */
	public static CacheingPersonEAO getInstance() {
		return inst;
	}

	/**
	 * Finds a person object in the data store by name. returns null if not found.
	 */
	@Override
	public Person findByName(final String name) {
		return data.get(name);
	}

	/**
	 * Returns all the entities stored in the database of type person.
	 */
	@Override
	public List<Person> findAll() {
		final List<Person> persons = new ArrayList<Person>(data.size());
		for (final Person p : data.values()) {
			persons.add(p);
		}
		return persons;
	}

	/**
	 * Saves a person in the data store.
	 */
	@Override
	public Person save(final Person person) {
		final String name = person.getName();
		if (!StringUtils.isBlank(name)) {
			data.put(name, person);
		}
		return person;
	}

	/**
	 * Removes a person from the data store.
	 */
	@Override
	public Person remove(final String name) {
		return data.remove(name);
	}
}
