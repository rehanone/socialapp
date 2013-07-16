package com.bjss.apps.socialgraph.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bjss.apps.socialgraph.command.parser.ParserContext;

public class WallCommondTest {

	@Test
	public void testExecute() {
		final ParserContext context = new ParserContext();
		context.setPersonName("Bob");
		final Command command = new WallCommond(context);

		assertEquals("\nWall: Bob\n", command.execute());
	}
}
