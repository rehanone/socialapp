package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.message.formatter.MessageFormatter;
import com.bjss.apps.socialgraph.message.formatter.WallMessageFormatter;
import com.bjss.apps.socialgraph.person.Person;

public class WallCommond extends AbstractCommand {

	private final ParserContext context;

	private final MessageFormatter formatter = new WallMessageFormatter();

	public WallCommond(final ParserContext context) {
		this.context = context;
	}

	@Override
	public String execute() {
		final String name = context.getPersonName();
		final Person person = getPerson(name);

		final StringBuilder sb = new StringBuilder();
		for (final Message msg : person.getWallMessages()) {
			sb.append(formatter.format(msg));
		}

		return "\nWall: " + name + "\n" + sb.toString();
	}
}
