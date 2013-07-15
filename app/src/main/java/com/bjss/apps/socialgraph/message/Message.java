package com.bjss.apps.socialgraph.message;

import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.Period;

import com.bjss.apps.socialgraph.person.Person;

public interface Message extends Comparable<Message> {

	UUID getId();

	DateTime getTimestamp();

	Person getSender();

	String getMessage();

	Period getAge();
}
