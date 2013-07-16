package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.entity.CacheingPersonEAO;
import com.bjss.apps.socialgraph.person.Person;

public abstract class AbstractCommand implements Command {

	protected Person getPerson(final String name) {
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
