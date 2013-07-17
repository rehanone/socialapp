package com.bjss.apps.socialgraph.graph.entity;

import static org.junit.Assert.assertTrue;

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
public class MessageTest {

	@Autowired
	private PersonService personService;

	@Autowired
	private Neo4jTemplate template;

	@Rollback(false)
	@BeforeTransaction
	public void cleanUpGraph() {
		Neo4jHelper.cleanDb(template);
	}

	@Test
	public void testCompareTo() throws InterruptedException {
		final Person alice = personService.save(new Person("Alice"));
		final Person bob = personService.save(new Person("Bob"));
		final Message alice_msg = template.save(new Message(alice, "alice_msg"));
		Thread.sleep(1200);
		final Message bob_msg = template.save(new Message(bob, "bob_msg"));

		assertTrue(alice_msg.compareTo(bob_msg) < 0);
		assertTrue(alice_msg.compareTo(alice_msg) == 0);
		assertTrue(bob_msg.compareTo(alice_msg) > 0);
	}
}
