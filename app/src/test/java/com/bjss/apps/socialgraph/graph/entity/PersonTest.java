package com.bjss.apps.socialgraph.graph.entity;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
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
public class PersonTest {

	@Autowired
	private Neo4jTemplate template;

	@Rollback(false)
	@BeforeTransaction
	public void cleanUpGraph() {
		Neo4jHelper.cleanDb(template);
	}

	@Test
	@Transactional
	public void persistedPersonShouldBeRetrievableFromGraphDb() {
		final Person bob = template.save(new Person("Bob"));
		final Person retrievedPerson = template.findOne(bob.getId(), Person.class);

		assertEquals("retrieved person matches persisted one", bob, retrievedPerson);
		assertEquals("retrieved person name matches", "Bob", retrievedPerson.getName());
	}

	@Test
	@Transactional
	public void findPersonByNameProperty() {
		final String name = "Alice";
		final Person alice = template.save(new Person(name));

		final GraphRepository<Person> personRepository = template.repositoryFor(Person.class);
		final Person retrievedPerson = personRepository.findByPropertyValue("name", name);

		assertEquals("retrieved person matches persisted one", alice, retrievedPerson);
		assertEquals("retrieved person name matches", name, retrievedPerson.getName());
	}

	@Test
	@Transactional
	public void hashcodeCaching() {
		final Set<Person> persons = new HashSet<Person>();
		final Person personX = new Person("Ghibli");
		persons.add(personX);
		template.save(personX);
		assertThat(persons.contains(personX), is(true));
		assertThat(persons.remove(personX), is(true));
		final Person samePersonX = template.findOne(personX.getId(), Person.class);
		assertThat(personX, is(equalTo(samePersonX)));
		assertThat(personX.hashCode(), is(not(equalTo(samePersonX.hashCode()))));
	}
}
