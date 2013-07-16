package com.bjss.apps.socialgraph;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class SocialOrchestratorTest {

	@Test
	public void testRun() {
		final SocialOrchestrator or = new SocialOrchestrator();

		final String input = readInput();
		final String[] contents = input.split("\n");

		for (final String token : contents) {
			or.run(token);
		}
	}

	private String readInput() {
		final InputStream in = this.getClass().getResourceAsStream("/test.txt");
		final String input = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
		return input;
	}
}
