package com.bjss.apps.socialgraph.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.bjss.apps.socialgraph.person.Person;

public class PersonDataStoreTest {

	private final PersonDataStore store = new PersonDataStore();

	@Test
	public void testGetPerson() {
		final String alice = "Alice";
		final String bob = "Bob";
		final Person person1 = store.getPerson(alice);
		final Person person2 = store.getPerson(bob);
		final Person person3 = store.getPerson(bob);

		assertNotEquals(person1, person2);
		assertEquals(person2, person3);
	}
}
