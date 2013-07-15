package com.bjss.apps.socialgraph.timeline;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class TimelineTest {

	@Mock
	Person person;

	@Test
	public void testPostMessage() throws InterruptedException {
		final Timeline timeline = new Timeline();

		timeline.postMessage(person, "msg");

		assertThat(timeline.getMessages().size(), is(1));
	}
}
