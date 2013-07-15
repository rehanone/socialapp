package com.bjss.apps.socialgraph.person;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.timeline.Timeline;
import com.bjss.apps.socialgraph.utils.SocialPeriodFormatter;

public class Person implements Followable, Follower {

	private final String name;

	private final Timeline timeline = new Timeline();

	private final Set<Followable> following = new HashSet<Followable>();

	public Person(final String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void postMessage(final String message) {
		timeline.postMessage(this, message);
	}

	@Override
	public String toString() {
		return "\nName: " + name + "\n" + timeline;
	}

	public void follows(final Followable followable) {
		following.add(followable);
	}

	/**
	 * The wall is generated dynamically by aggregating all messages from the followable's
	 * timelines. This approach is not very efficient as it requires dynamic merging of timelines as
	 * each view of the wall.
	 */
	public String wall() {
		final Set<Message> wall = new TreeSet<Message>();
		wall.addAll(getMessages());
		for (final Followable followable : following) {
			wall.addAll(followable.getMessages());
		}

		final StringBuilder sb = new StringBuilder();
		for (final Message msg : wall) {
			sb.append(String.format("\n %s - %s (%s ago)", msg.getSender().getName(), msg.getMessage(),
					SocialPeriodFormatter.toString(msg.getAge())));
		}
		return sb.toString();
	}

	public Set<Message> getMessages() {
		return timeline.getMessages();
	}
}
