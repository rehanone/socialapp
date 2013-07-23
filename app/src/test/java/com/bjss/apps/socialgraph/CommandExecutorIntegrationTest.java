package com.bjss.apps.socialgraph;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.support.node.Neo4jHelper;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import com.bjss.apps.socialgraph.command.CommandExecutor;

@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CommandExecutorIntegrationTest {

	@Autowired
	private CommandExecutor executor;

	@Autowired
	private Neo4jTemplate template;

	@Rollback(false)
	@BeforeTransaction
	public void cleanUpGraph() {
		Neo4jHelper.cleanDb(template);
	}

	@Test
	public void testRunWithErrorInputHandling() {
		final String input = readInput();
		final String[] contents = input.split("\n");

		for (final String token : contents) {
			final String newToken = StringUtils.stripEnd(token, "\r");
			executor.run(newToken);
		}
	}

	private String readInput() {
		final InputStream in = this.getClass().getResourceAsStream("/test.txt");
		final String input = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
		return input;
	}
}
