package com.bjss.apps.socialgraph.message;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class TextMessageTest {

	@Mock
	Person person;

	@Test
	public void testgetAge() throws InterruptedException {
		final Message m1 = new TextMessage(person, "m1");
		Thread.sleep(1200);
		final Message m2 = new TextMessage(person, "m2");

		assertTrue(m1.getAge().toStandardDuration().getMillis() > 1200);
		assertTrue(m2.getAge().toStandardDuration().getMillis() > 0);
	}
}
