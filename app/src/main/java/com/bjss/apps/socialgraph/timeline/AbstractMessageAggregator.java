package com.bjss.apps.socialgraph.timeline;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.bjss.apps.socialgraph.message.Message;

/**
 * AbstractMessageAggregator provides an ordered collection of messages.
 * 
 * @author rehan.mahmood
 * 
 */
public abstract class AbstractMessageAggregator {

	// Using TreeSet will store messages in there natural sort order (Datewise)
	private final SortedSet<Message> messages = new TreeSet<Message>();

	/**
	 * Provides an unmodifiable view of the stored messages.
	 * 
	 * @return SortedSet<Message>
	 */
	public SortedSet<Message> getMessages() {
		return Collections.unmodifiableSortedSet(messages);
	}

	/**
	 * Posts a Massage for storage in the message aggregate
	 * 
	 * @param message
	 */
	public void postMessage(final Message message) {
		messages.add(message);
	}
}
