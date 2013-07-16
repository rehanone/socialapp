package com.bjss.apps.socialgraph.command;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.command.parser.ParserFactory;
import com.bjss.apps.socialgraph.command.parser.ParserState;

@RunWith(MockitoJUnitRunner.class)
public class SocialCommandParserTest {

	@Mock
	private CommandFactory commandFactory;

	@Mock
	private ParserFactory parserFactory;

	@Mock
	private ParserContext context;

	@Mock
	private ParserState state;

	@Mock
	private Command command;

	private CommandParser parser;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		parser = new SocialCommandParser(commandFactory, parserFactory);

		when(parserFactory.createContext()).thenReturn(context);
		when(parserFactory.createStartState()).thenReturn(state);
		when(commandFactory.getCommand(context)).thenReturn(command);
		when(state.parse(anyString(), eq(context))).thenReturn(state);
	}

	@Test
	public void testParse_wall_moreInput() {
		final Command result = parser.parse("Alice -> hello world!");

		Assert.assertEquals(command, result);
		verify(parserFactory, times(1)).createContext();
		verify(parserFactory, times(1)).createStartState();
		verify(state, times(4)).parse(anyString(), eq(context));
		verify(commandFactory, times(1)).getCommand(context);
	}
}
