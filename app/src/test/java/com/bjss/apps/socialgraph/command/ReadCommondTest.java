package com.bjss.apps.socialgraph.command;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.SortedSet;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.message.formatter.MessageFormatter;
import com.bjss.apps.socialgraph.person.Person;
import com.bjss.apps.socialgraph.store.PersonDataStore;
import com.google.common.collect.Sets;

@RunWith(MockitoJUnitRunner.class)
public class ReadCommondTest {

	private static final String NAME = "Bob";

	@Mock
	private PersonDataStore store;

	@Mock
	private Person person;

	@Mock
	private Message message;

	@Mock
	private MessageFormatter formatter;

	@Test
	public void testExecute_emptyWall() {
		final ParserContext context = new ParserContext();
		context.setPersonName(NAME);

		when(store.getPerson(NAME)).thenReturn(person);
		when(person.getTimelineMessages()).thenReturn(Sets.<Message> newTreeSet());

		final Command command = new ReadCommond(store, context, formatter);

		assertTrue(StringUtils.contains(command.execute(), "Timeline: Bob"));

		verify(person, times(1)).getTimelineMessages();
		verifyZeroInteractions(formatter);
	}

	@Test
	public void testExecute() {
		final ParserContext context = new ParserContext();
		context.setPersonName(NAME);

		final SortedSet<Message> messages = Sets.<Message> newTreeSet();
		messages.add(message);

		when(store.getPerson(NAME)).thenReturn(person);
		when(person.getTimelineMessages()).thenReturn(messages);

		final Command command = new ReadCommond(store, context, formatter);

		assertTrue(StringUtils.contains(command.execute(), "Timeline: Bob"));

		verify(person, times(1)).getTimelineMessages();
		verify(formatter, times(1)).format(message);
	}
}
