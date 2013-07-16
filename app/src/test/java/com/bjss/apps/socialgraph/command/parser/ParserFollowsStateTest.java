package com.bjss.apps.socialgraph.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParserFollowsStateTest {

	@Test(expected = ParserException.class)
	public void testParse_invalid() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserFollowsState();
		state.parse("-", context);
	}

	@Test
	public void testParse_valid() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserFollowsState();
		final ParserState result = state.parse("rehan", context);

		assertNotNull(result);
		assertTrue(result instanceof ParserStopState);
		assertEquals("rehan", context.getSecondPersonName());
	}
}
