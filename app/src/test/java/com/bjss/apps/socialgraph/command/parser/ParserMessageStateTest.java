package com.bjss.apps.socialgraph.command.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParserMessageStateTest {

	@Test
	public void testParse() {
		final ParserContext context = new ParserContext();
		final ParserState state = new ParserMessageState();
		ParserState result = state.parse("Hello", context);
		result = result.parse("World!", context);

		assertEquals("Hello World! ", context.getMessage());
	}
}
