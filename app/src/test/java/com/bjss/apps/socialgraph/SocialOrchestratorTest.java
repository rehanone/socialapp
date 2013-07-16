package com.bjss.apps.socialgraph;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class SocialOrchestratorTest {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Test
	public void testRunWithErrorInputHandling() {
		final SocialOrchestrator or = new SocialOrchestrator();

		final String input = readInput();
		final String[] contents = input.split(LINE_SEPARATOR);

		for (final String token : contents) {
			final String newToken = StringUtils.stripEnd(token, "\r");
			or.run(newToken);
		}
	}

	private String readInput() {
		final InputStream in = this.getClass().getResourceAsStream("/test.txt");
		final String input = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
		return input;
	}
}
