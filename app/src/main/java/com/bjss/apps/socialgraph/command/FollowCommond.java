package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.graph.entity.Person;
import com.bjss.apps.socialgraph.store.PersonDataStore;

public class FollowCommond implements Command {

	private final ParserContext context;

	private final PersonDataStore store;

	public FollowCommond(final PersonDataStore store, final ParserContext context) {
		this.context = context;
		this.store = store;
	}

	@Override
	public String execute() {
		final String firstName = context.getPersonName();
		final String secondName = context.getSecondPersonName();
		final Person firstPerson = store.getPerson(firstName);
		final Person secondPerson = store.getPerson(secondName);
		firstPerson.follow(secondPerson);
		store.savePerson(firstPerson);
		return "";
	}
}
