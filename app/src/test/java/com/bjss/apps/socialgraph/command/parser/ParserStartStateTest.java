package com.bjss.apps.socialgraph.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParserStartStateTest {

	@Test(expected = ParserException.class)
	public void testParse_invalid() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserStartState();
		state.parse("-", context);
	}

	@Test
	public void testParse_valid() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserStartState();
		final ParserState result = state.parse("rehan", context);

		assertNotNull(result);
		assertTrue(result instanceof ParserCommandState);
		assertEquals("rehan", context.getPersonName());
		assertEquals(CommandType.READ, context.getType());
	}
}
