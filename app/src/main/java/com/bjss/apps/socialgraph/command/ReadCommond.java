package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.message.formatter.MessageFormatter;
import com.bjss.apps.socialgraph.message.formatter.TimelineMessageFormatter;
import com.bjss.apps.socialgraph.person.Person;

/**
 * ReadCommand
 * 
 * @author rehan.mahmood
 * 
 */
public class ReadCommond extends AbstractCommand {

	private final ParserContext context;

	private final MessageFormatter formatter = new TimelineMessageFormatter();

	public ReadCommond(final ParserContext context) {
		this.context = context;
	}

	@Override
	public String execute() {
		final String name = context.getPersonName();
		final Person person = getPerson(name);

		final StringBuilder sb = new StringBuilder();
		for (final Message msg : person.getTimelineMessages()) {
			sb.append(formatter.format(msg));
		}

		return "\nTimeline: " + name + "\n" + sb.toString();
	}
}
