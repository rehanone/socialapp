package com.bjss.apps.socialgraph.command;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.graph.entity.Message;
import com.bjss.apps.socialgraph.graph.entity.Person;
import com.bjss.apps.socialgraph.store.PersonDataStore;

@RunWith(MockitoJUnitRunner.class)
public class MessageCommandTest {

	private static final String NAME = "Bob";

	@Mock
	private PersonDataStore store;

	@Mock
	private Person person;

	@Mock
	private Message message;

	@Test
	public void testExecute() {
		final String text = "hi";
		final ParserContext context = new ParserContext();
		context.setPersonName(NAME);
		context.appendMessage(text);

		when(store.getPerson(NAME)).thenReturn(person);

		final Command command = new MessageCommand(store, context);
		command.execute();

		verify(person, times(1)).postMessage(text + " ");
		verify(store, times(1)).savePerson(person);
	}
}
