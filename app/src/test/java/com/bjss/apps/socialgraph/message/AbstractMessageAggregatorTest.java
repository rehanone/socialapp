package com.bjss.apps.socialgraph.message;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class AbstractMessageAggregatorTest {

	@Mock
	Person person;

	@Test(expected = UnsupportedOperationException.class)
	public void testGetMessages_readonly() {
		final MessageAggregator aggregate = new MessageAggregator();

		final Message m1 = new TextMessage(person, "m1");
		aggregate.getMessages().add(m1);
	}

	@Test
	public void testPostMessage_noMultipleInserts() throws InterruptedException {
		final MessageAggregator aggregate = new MessageAggregator();
		final Message m1 = new TextMessage(person, "m1");

		aggregate.postMessage(m1);
		aggregate.postMessage(m1);

		assertThat(aggregate.getMessages().size(), is(1));
		assertThat(aggregate.getMessages(), hasItem(m1));
	}
}
