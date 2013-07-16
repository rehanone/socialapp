package com.bjss.apps.socialgraph.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bjss.apps.socialgraph.command.parser.ParserContext;

public class ReadCommondTest {

	@Test
	public void testExecute() {
		final ParserContext context = new ParserContext();
		context.setPersonName("Bob");
		final Command command = new ReadCommond(context);

		assertEquals("\nTimeline: Bob\n", command.execute());
	}
}
