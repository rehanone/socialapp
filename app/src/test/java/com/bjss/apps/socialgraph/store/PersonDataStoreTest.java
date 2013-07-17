package com.bjss.apps.socialgraph.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

import com.bjss.apps.socialgraph.graph.entity.Person;

@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonDataStoreTest {

	@Autowired
	private PersonDataStore store;

	@Autowired
	private Neo4jTemplate template;

	@Rollback(false)
	@BeforeTransaction
	public void cleanUpGraph() {
		Neo4jHelper.cleanDb(template);
	}

	@Test
	@Transactional
	public void testGetPerson() {
		final String alice = "Alice";
		final String bob = "Bob";
		final Person person1 = store.getPerson(alice);
		final Person person2 = store.getPerson(bob);
		final Person person3 = store.getPerson(bob);

		assertNotEquals(person1, person2);
		assertEquals(person2, person3);
	}
}
