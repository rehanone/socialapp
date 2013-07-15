package com.bjss.apps.socialgraph.message;

import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.Period;

import com.bjss.apps.socialgraph.person.Person;

public class TextMessage implements Message {

	private final UUID id = UUID.randomUUID();

	private final DateTime timestamp = new DateTime();

	private final Person sender;

	private final String message;

	public TextMessage(final Person sender, final String message) {
		this.sender = sender;
		this.message = message;
	}

	public UUID getId() {
		return id;
	}

	public Person getSender() {
		return sender;
	}

	public String getMessage() {
		return message;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	public Period getAge() {
		final DateTime now = new DateTime();
		final Period age = new Period(timestamp, now);
		return age;
	}

	public int compareTo(final Message o) {
		final int timestampCompare = this.timestamp.compareTo(o.getTimestamp());

		return timestampCompare == 0 ? this.id.compareTo(o.getId()) : timestampCompare;
	}
}
