package com.bjss.apps.socialgraph.person;

import java.util.HashSet;
import java.util.Set;

import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.message.TextMessage;
import com.bjss.apps.socialgraph.timeline.Timeline;
import com.bjss.apps.socialgraph.timeline.Wall;

public class Person implements Followable, Follower {

	private final String name;

	private final Timeline timeline = new Timeline();

	private final Wall wall = new Wall();

	private final Set<Follower> followers = new HashSet<Follower>();

	public Person(final String name) {
		super();
		this.name = name;
		followers.add(this);
	}

	public String getName() {
		return name;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void postMessage(final String message) {
		final Message msg = new TextMessage(this, message);
		timeline.postMessage(msg);
		publishUpdate(msg);
	}

	/**
	 * Register an interested person for updates
	 */
	public void addFollower(final Follower follower) {
		followers.add(follower);
		// post all of your timeline to the follower's wall
		for (final Message msg : timeline.getMessages()) {
			follower.update(msg);
		}
	}

	public void publishUpdate(final Message msg) {
		for (final Follower follower : followers) {
			follower.update(msg);
		}
	}

	/**
	 * Update received from persons we are following. This update is posted to the current persons
	 * wall.
	 */
	public void update(final Message msg) {
		wall.postMessage(msg);
	}

	public String getTimelineAsString() {
		return "\nTimeline: " + name + "\n" + timeline;
	}

	public String getWallAsString() {
		return "\nWall: " + name + "\n" + wall;
	}
}