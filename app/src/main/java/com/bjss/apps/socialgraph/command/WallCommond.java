package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.person.Person;

public class WallCommond extends AbstractCommand {

	private final ParserContext context;

	public WallCommond(final ParserContext context) {
		this.context = context;
	}

	@Override
	public String execute() {
		final String name = context.getPersonName();
		final Person person = getPerson(name);
		return person.getWallAsString();
	}
}
