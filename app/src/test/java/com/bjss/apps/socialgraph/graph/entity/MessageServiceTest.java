package com.bjss.apps.socialgraph.graph.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

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

@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class MessageServiceTest {

	private static final String ALICE_MSG = "alice_msg";

	@Autowired
	private MessageService messageService;

	@Autowired
	private Neo4jTemplate template;

	@Rollback(false)
	@BeforeTransaction
	public void cleanUpGraph() {
		Neo4jHelper.cleanDb(template);
	}

	@Test
	public void saved_message_should_have_an_id() {
		final Person alice = template.save(new Person("Alice"));
		final Message alice_msg = messageService.save(new Message(alice, ALICE_MSG));

		assertThat("persisted message should have an id", alice_msg.getId(), notNullValue());
	}
}
