package com.bjss.apps.socialgraph.command;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.person.Person;
import com.bjss.apps.socialgraph.store.PersonDataStore;

@RunWith(MockitoJUnitRunner.class)
public class FollowCommondTest {

	private static final String ALICE = "Alice";
	private static final String BOB = "Bob";

	@Mock
	private PersonDataStore store;

	@Mock
	private Person alice;

	@Mock
	private Person bob;

	@Test
	public void testExecute() {
		final ParserContext context = new ParserContext();
		context.setPersonName(ALICE);
		context.setSecondPersonName(BOB);

		when(store.getPerson(ALICE)).thenReturn(alice);
		when(store.getPerson(BOB)).thenReturn(bob);

		final Command command = new FollowCommond(store, context);
		command.execute();

		verify(bob, times(1)).addFollower(alice);
	}
}
