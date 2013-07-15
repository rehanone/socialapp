package com.bjss.apps.socialgraph.message;

import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.Period;

import com.bjss.apps.socialgraph.person.Person;

/**
 * Defines the interface for a message/status update in a social context. Messages are comparable
 * wrt their creation timestamp.
 * 
 * @author rehan.mahmood
 * 
 */
public interface Message extends Comparable<Message> {

	UUID getId();

	DateTime getTimestamp();

	Person getOwner();

	String getMessage();

	Period getAge();
}
