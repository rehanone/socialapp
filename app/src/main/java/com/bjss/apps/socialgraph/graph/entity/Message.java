package com.bjss.apps.socialgraph.graph.entity;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Message implements Comparable<Message> {

	private static final String OWN = "OWN";

	@GraphId
	private Long id;

	@GraphProperty(propertyType = Long.class)
	private final DateTime timestamp = new DateTime(DateTimeZone.UTC);

	@Fetch
	@RelatedTo(type = OWN, direction = Direction.OUTGOING, elementClass = Person.class)
	private Person owner;

	private String message;

	public Message() {
	}

	public Message(final Person owner, final String message) {
		this.owner = owner;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public Person getOwner() {
		return owner;
	}

	public String getMessage() {
		return message;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	public Period getAge() {
		final DateTime now = new DateTime(DateTimeZone.UTC);
		final Period age = new Period(timestamp, now);
		return age;
	}

	@Override
	public int compareTo(final Message o) {
		final int timestampCompare = this.timestamp.compareTo(o.getTimestamp());

		return timestampCompare == 0 ? this.id.compareTo(o.getId()) : timestampCompare;
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

		if (!(other instanceof Message))
			return false;

		return id.equals(((Message) other).id);
	}

	@Override
	public String toString() {
		return "Message [timestamp=" + timestamp + ", owner=" + owner + ", message=" + message + "]";
	}
}
