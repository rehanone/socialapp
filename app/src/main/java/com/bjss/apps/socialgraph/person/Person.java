package com.bjss.apps.socialgraph.person;

import com.bjss.apps.socialgraph.timeline.Timeline;

public class Person {

	private final String name;

	private final Timeline timeline = new Timeline();

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
}
