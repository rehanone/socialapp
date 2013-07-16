package com.bjss.apps.socialgraph.command;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SocialCommandParserTest {

	@Test
	public void testParse_read() {
		final CommandParser parser = new SocialCommandParser();

		final Command command = parser.parse("Alice");

		assertTrue(command instanceof ReadCommond);
	}

	@Test
	public void testParse_read_moreInput() {
		final CommandParser parser = new SocialCommandParser();

		final Command command = parser.parse("Alice ignore this");

		assertTrue(command instanceof ReadCommond);
	}

	@Test
	public void testParse_message() {
		final CommandParser parser = new SocialCommandParser();

		final Command command = parser.parse("Alice -> hello world!");

		assertTrue(command instanceof MessageCommand);
	}

	@Test
	public void testParse_follows() {
		final CommandParser parser = new SocialCommandParser();

		final Command command = parser.parse("Alice follows Bob");

		assertTrue(command instanceof FollowCommond);
	}

	@Test
	public void testParse_wall() {
		final CommandParser parser = new SocialCommandParser();

		final Command command = parser.parse("Alice wall");

		assertTrue(command instanceof WallCommond);
	}

	@Test
	public void testParse_wall_moreInput() {
		final CommandParser parser = new SocialCommandParser();

		final Command command = parser.parse("Alice wall ignore this");

		assertTrue(command instanceof WallCommond);
	}
}
