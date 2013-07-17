package com.bjss.apps.socialgraph.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjss.apps.socialgraph.graph.entity.Person;
import com.bjss.apps.socialgraph.graph.entity.PersonService;

@Service
public class PersonDataStore {

	private final PersonService personService;

	@Autowired
	public PersonDataStore(final PersonService personService) {
		this.personService = personService;
	}

	@Transactional
	public Person getPerson(final String name) {
		Person person = personService.findByName(name);
		if (person == null) {
			person = new Person(name);
			person = personService.save(person);
		}
		return person;
	}

	public void savePerson(final Person person) {
		personService.save(person);
	}
}
