package com.bjss.apps.socialgraph.person;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

	private static final String ALICE_M1 = "I love the weather today";

	@Test
	public void testPostMessage() {
		final Person alice = new Person("Alice");
		alice.postMessage(ALICE_M1);

		final Person bob = new Person("Bob");
		bob.postMessage("Oh, we lost!");
		bob.postMessage("at least it's sunny");

		assertEquals(1, alice.getTimeline().getMessages().size());
		assertEquals(2, bob.getTimeline().getMessages().size());
	}
}
