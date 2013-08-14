package com.bjss.apps.socialgraph.graph.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessageTest {

	private static final String ALICE_MSG = "alice_msg";
	private static final String BOB_MSG = "bob_msg";

	@Mock
	private Person alice;

	@Mock
	private Person bob;

	private Message alice_msg;
	private Message bob_msg;

	@Before
	public void setUp() throws InterruptedException {
		alice_msg = new Message(alice, ALICE_MSG);
		Thread.sleep(1200);
		bob_msg = new Message(bob, BOB_MSG);
	}

	@Test
	public void compare_should_return_less_then_zero_for_earlier_message() {

		final int result = alice_msg.compareTo(bob_msg);

		assertThat("Alice's message should be older than Bob's message", result, lessThan(0));
	}

	@Test
	public void compare_should_return_zero_for_same_message() {

		final int result = alice_msg.compareTo(alice_msg);

		assertThat("Alice's message should be equal to her own message", result, equalTo(0));
	}

	@Test
	public void compare_should_return_greater_then_zero_for_later_message() {

		final int result = bob_msg.compareTo(alice_msg);

		assertThat("Bob's message should be greater then Alice's message", result, greaterThan(0));
	}
}
