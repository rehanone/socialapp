package com.bjss.apps.socialgraph.command;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.bjss.apps.socialgraph.command.parser.ParserContext;

public class WallCommondTest {

	@Test
	public void testExecute() {
		final ParserContext context = new ParserContext();
		context.setPersonName("Bob");
		final Command command = new WallCommond(context);

		assertTrue(StringUtils.contains(command.execute(), "Wall: Bob"));
	}
}
