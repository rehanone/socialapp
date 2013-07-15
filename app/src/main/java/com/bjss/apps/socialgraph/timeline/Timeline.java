package com.bjss.apps.socialgraph.timeline;

import java.util.Set;
import java.util.TreeSet;

import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.message.TextMessage;
import com.bjss.apps.socialgraph.person.Person;
import com.bjss.apps.socialgraph.utils.SocialPeriodFormatter;

public class Timeline {

	private final Set<Message> messages = new TreeSet<Message>();

	public void postMessage(final Person person, final String message) {
		final Message msg = new TextMessage(person, message);
		messages.add(msg);
	}

	public Set<Message> getMessages() {
		return messages;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for (final Message msg : messages) {
			sb.append(String.format("\n %s (%s ago)", msg.getMessage(), SocialPeriodFormatter.toString(msg.getAge())));
		}
		return sb.toString();
	}
}
