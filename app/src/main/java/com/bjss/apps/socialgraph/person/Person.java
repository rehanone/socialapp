package com.bjss.apps.socialgraph.person;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

import com.bjss.apps.socialgraph.entity.NameIdentifiable;
import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.message.MessageAggregator;
import com.bjss.apps.socialgraph.message.TextMessage;

public class Person extends NameIdentifiable implements Followable, Follower {

	private final String name;

	private final MessageAggregator timeline = new MessageAggregator();

	private final MessageAggregator wall = new MessageAggregator();

	private final Set<Follower> followers = new HashSet<Follower>();

	public Person(final String name) {
		super();
		this.name = name;
		// Add a self reference as a follower to receive updates on the personal wall.
		followers.add(this);
	}

	@Override
	public String getName() {
		return name;
	}

	public SortedSet<Message> getTimelineMessages() {
		return timeline.getMessages();
	}

	public SortedSet<Message> getWallMessages() {
		return wall.getMessages();
	}

	public void postMessage(final String message) {
		final Message msg = new TextMessage(this, message);
		timeline.postMessage(msg);
		publishUpdate(msg);
	}

	/**
	 * Register an interested person for updates
	 */
	@Override
	public void addFollower(final Follower follower) {
		followers.add(follower);
		// post all of your timeline to the follower's wall
		for (final Message msg : timeline.getMessages()) {
			follower.update(msg);
		}
	}

	@Override
	public void publishUpdate(final Message msg) {
		for (final Follower follower : followers) {
			follower.update(msg);
		}
	}

	/**
	 * Update received from persons we are following. This update is posted to the current persons
	 * wall.
	 */
	@Override
	public void update(final Message msg) {
		wall.postMessage(msg);
	}
}
