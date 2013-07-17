package com.bjss.apps.socialgraph.graph.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person findById(final Long id) {
		return personRepository.findOne(id);
	}

	public Person findByName(final String name) {
		return personRepository.findByPropertyValue("name", name);
	}

	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	public long getNumberOfPersons() {
		return personRepository.count();
	}

	public Person save(final Person person) {
		return personRepository.save(person);
	}
}
