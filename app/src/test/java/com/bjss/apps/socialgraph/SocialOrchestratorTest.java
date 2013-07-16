package com.bjss.apps.socialgraph;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class SocialOrchestratorTest {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Test
	public void testRunWithErrorInputHandling() {
		final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		final SocialOrchestrator orchestrator = (SocialOrchestrator) context.getBean("socialOrchestrator");

		final String input = readInput();
		final String[] contents = input.split(LINE_SEPARATOR);

		for (final String token : contents) {
			final String newToken = StringUtils.stripEnd(token, "\r");
			orchestrator.run(newToken);
		}
	}

	private String readInput() {
		final InputStream in = this.getClass().getResourceAsStream("/test.txt");
		final String input = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
		return input;
	}
}
