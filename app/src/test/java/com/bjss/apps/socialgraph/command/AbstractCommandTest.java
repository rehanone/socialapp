package com.bjss.apps.socialgraph.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.bjss.apps.socialgraph.person.Person;

public class AbstractCommandTest {

	@Test
	public void testGetPerson() {
		final Command command = new AbstractCommand() {

			@Override
			public String execute() {
				final String alice = "Alice";
				final String bob = "Bob";
				final Person person1 = getPerson(alice);
				final Person person2 = getPerson(bob);
				final Person person3 = getPerson(bob);

				assertNotEquals(person1, person2);
				assertEquals(person2, person3);

				return null;
			}
		};
		command.execute();
	}
}
