package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.message.formatter.MessageFormatter;
import com.bjss.apps.socialgraph.person.Person;
import com.bjss.apps.socialgraph.store.PersonDataStore;

public class WallCommond implements Command {

	private final ParserContext context;

	private final PersonDataStore store;

	private final MessageFormatter formatter;

	public WallCommond(final PersonDataStore store, final ParserContext context, final MessageFormatter formatter) {
		this.context = context;
		this.store = store;
		this.formatter = formatter;
	}

	@Override
	public String execute() {
		final String name = context.getPersonName();
		final Person person = store.getPerson(name);

		final StringBuilder sb = new StringBuilder();
		for (final Message msg : person.getWallMessages()) {
			sb.append(formatter.format(msg));
		}

		return "\nWall: " + name + "\n" + sb.toString();
	}
}
