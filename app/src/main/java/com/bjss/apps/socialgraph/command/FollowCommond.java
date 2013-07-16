package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.person.Person;

public class FollowCommond extends AbstractCommand {

	private final ParserContext context;

	public FollowCommond(final ParserContext context) {
		this.context = context;
	}

	@Override
	public String execute() {
		final String firstName = context.getPersonName();
		final String secondName = context.getSecondPersonName();
		final Person firstPerson = getPerson(firstName);
		final Person secondPerson = getPerson(secondName);
		secondPerson.addFollower(firstPerson);
		return "";
	}
}
