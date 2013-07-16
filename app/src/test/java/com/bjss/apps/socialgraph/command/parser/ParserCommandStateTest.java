package com.bjss.apps.socialgraph.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParserCommandStateTest {

	@Test
	public void testParse_MessageCommand() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserCommandState();
		final ParserState result = state.parse("->", context);

		assertNotNull(result);
		assertTrue(result instanceof ParserMessageState);
		assertEquals(CommandType.MESSAGE, context.getType());
	}

	@Test
	public void testParse_FollowsState() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserCommandState();
		final ParserState result = state.parse("follows", context);

		assertNotNull(result);
		assertTrue(result instanceof ParserFollowsState);
		assertEquals(CommandType.FOLLOW, context.getType());
	}

	@Test
	public void testParse_WallState() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserCommandState();
		final ParserState result = state.parse("wall", context);

		assertNotNull(result);
		assertTrue(result instanceof ParserStopState);
		assertEquals(CommandType.WALL, context.getType());
	}

	@Test
	public void testParse_StopState() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserCommandState();
		final ParserState result = state.parse("anything", context);

		assertNotNull(result);
		assertTrue(result instanceof ParserStopState);
	}
}
