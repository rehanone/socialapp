package com.bjss.apps.socialgraph.store;

import org.springframework.stereotype.Component;

import com.bjss.apps.socialgraph.entity.CacheingPersonEAO;
import com.bjss.apps.socialgraph.person.Person;

@Component
public class PersonDataStore {

	public Person getPerson(final String name) {
		Person person = getData().findByName(name);
		if (person == null) {
			person = new Person(name);
			getData().save(person);
		}
		return person;
	}

	private CacheingPersonEAO getData() {
		return CacheingPersonEAO.getInstance();
	}
}
