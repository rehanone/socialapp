package com.bjss.apps.socialgraph.timeline;

import static org.junit.Assert.assertEquals;

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

		assertEquals(1, timeline.getMessages().size());
		assertEquals("msg", timeline.getMessages().get(0).getMessage());
	}
}
