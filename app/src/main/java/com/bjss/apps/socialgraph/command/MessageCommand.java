package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.graph.entity.Person;
import com.bjss.apps.socialgraph.store.PersonDataStore;

public class MessageCommand implements Command {

	private final ParserContext context;

	private final PersonDataStore store;

	public MessageCommand(final PersonDataStore store, final ParserContext context) {
		this.context = context;
		this.store = store;
	}

	@Override
	public String execute() {
		final String name = context.getPersonName();
		final Person person = store.getPerson(name);
		person.postMessage(context.getMessage());
		store.savePerson(person);
		return "";
	}
}
