package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.person.Person;

public class MessageCommand extends AbstractCommand {

	private final ParserContext context;

	public MessageCommand(final ParserContext context) {
		this.context = context;
	}

	@Override
	public String execute() {
		final String name = context.getPersonName();
		final Person person = getPerson(name);
		person.postMessage(context.getMessage());
		return "";
	}
}
