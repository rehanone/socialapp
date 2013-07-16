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
public class WallCommondTest {

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
		when(person.getWallMessages()).thenReturn(Sets.<Message> newTreeSet());

		final Command command = new WallCommond(store, context, formatter);

		assertTrue(StringUtils.contains(command.execute(), "Wall: Bob"));

		verify(person, times(1)).getWallMessages();
		verifyZeroInteractions(formatter);
	}

	@Test
	public void testExecute() {
		final ParserContext context = new ParserContext();
		context.setPersonName(NAME);

		final SortedSet<Message> messages = Sets.<Message> newTreeSet();
		messages.add(message);

		when(message.getMessage()).thenReturn("hi");
		when(store.getPerson(NAME)).thenReturn(person);
		when(person.getWallMessages()).thenReturn(messages);

		final Command command = new WallCommond(store, context, formatter);

		assertTrue(StringUtils.contains(command.execute(), "Wall: Bob"));

		verify(person, times(1)).getWallMessages();
		verify(formatter, times(1)).format(message);
	}
}
