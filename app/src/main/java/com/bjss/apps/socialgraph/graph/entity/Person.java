package com.bjss.apps.socialgraph.graph.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Person {

	private static final String OWN = "OWN";

	@GraphId
	private Long id;

	@Indexed(unique = true)
	private String name;

	@Fetch
	@RelatedTo(type = OWN, direction = Direction.INCOMING)
	private final Set<Message> timeline = new HashSet<Message>();

	@Fetch
	@RelatedTo(direction = Direction.BOTH, elementClass = Person.class)
	private final Set<Person> following = new HashSet<Person>();

	public Person() {
	}

	public Person(final String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Message> getTimelineMessages() {
		final Set<Message> timeline = new TreeSet<Message>();
		timeline.addAll(this.timeline);
		return timeline;
	}

	public Set<Message> getWallMessages() {
		final Set<Message> wall = new TreeSet<Message>();
		wall.addAll(getTimelineMessages());
		for (final Person f : following) {
			wall.addAll(f.getTimelineMessages());
		}
		return wall;
	}

	public void postMessage(final String message) {
		timeline.add(new Message(this, message));
	}

	public void follow(final Person friend) {
		following.add(friend);
	}

	transient private Integer hash;

	@Override
	public int hashCode() {
		if (hash == null)
			hash = id == null ? System.identityHashCode(this) : id.hashCode();

		return hash.hashCode();
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;

		if (id == null)
			return false;

		if (!(other instanceof Person))
			return false;

		return id.equals(((Person) other).id);
	}

	@Override
	public String toString() {
		return String.format("Person{name='%s'}", name);
	}
}
