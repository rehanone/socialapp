package com.bjss.apps.socialgraph.message;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.bjss.apps.socialgraph.message.Message;

/**
 * MessageAggregator provides an ordered collection of messages.
 * 
 * @author rehan.mahmood
 * 
 */
public class MessageAggregator {

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
