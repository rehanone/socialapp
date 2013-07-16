package com.bjss.apps.socialgraph.person;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.message.Message;

@RunWith(MockitoJUnitRunner.class)
public class PersonTest {

	private static final String ALICE_M1 = "I love the weather today";

	private static final String BOB_M2 = "at least it's sunny";

	private static final String BOB_M1 = "Oh, we lost!";

	@Mock
	private Person person;

	@Mock
	private Message message;

	@Test
	public void testPostMessage() {
		final Person alice = new Person("Alice");
		alice.postMessage(ALICE_M1);

		final Person bob = new Person("Bob");
		bob.postMessage(BOB_M1);
		bob.postMessage(BOB_M2);

		assertThat(alice.getTimelineMessages().size(), is(1));
		assertThat(bob.getTimelineMessages().size(), is(2));

		assertThat(alice.getWallMessages().size(), is(1));
		assertThat(bob.getWallMessages().size(), is(2));
	}

	@Test
	public void testAddFollower() {
		final Person bob = new Person("Bob");
		bob.postMessage(BOB_M1);
		bob.postMessage(BOB_M2);

		bob.addFollower(person);

		verify(person, times(2)).update(any(Message.class));
	}

	@Test
	public void testPublishUpdate() {
		final Person alice = new Person("Alice");

		alice.addFollower(person);
		alice.publishUpdate(message);

		verify(person, times(1)).update(any(Message.class));
	}

	@Test
	public void testUpdate() {
		final Person alice = new Person("Alice");
		alice.update(message);

		final Person bob = new Person("Bob");
		bob.update(message);

		assertThat(alice.getTimelineMessages().size(), is(0));
		assertThat(bob.getTimelineMessages().size(), is(0));

		assertThat(alice.getWallMessages().size(), is(1));
		assertThat(bob.getWallMessages().size(), is(1));

		assertThat(alice.getWallMessages(), hasItem(message));
		assertThat(bob.getWallMessages(), hasItem(message));
	}
}
