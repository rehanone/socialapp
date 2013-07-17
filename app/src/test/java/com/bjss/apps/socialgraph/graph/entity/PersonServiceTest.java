package com.bjss.apps.socialgraph.graph.entity;

import static org.junit.Assert.assertEquals;

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
public class PersonServiceTest {

	@Autowired
	private PersonService service;

	@Autowired
	private Neo4jTemplate template;

	@Rollback(false)
	@BeforeTransaction
	public void cleanUpGraph() {
		Neo4jHelper.cleanDb(template);
	}

	@Test
	@Transactional
	public void persistedMovieShouldBeRetrievableFromGraphDb() {
		final Person bob = service.save(new Person("Bob"));
		final Person retrievedPerson = template.findOne(bob.getId(), Person.class);

		assertEquals("retrieved person matches persisted one", bob, retrievedPerson);
		assertEquals("retrieved person name matches", "Bob", retrievedPerson.getName());
	}
}
