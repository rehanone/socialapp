package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.graph.entity.Message;
import com.bjss.apps.socialgraph.graph.entity.Person;
import com.bjss.apps.socialgraph.message.formatter.MessageFormatter;
import com.bjss.apps.socialgraph.store.PersonDataStore;

/**
 * ReadCommand
 * 
 * @author rehan.mahmood
 * 
 */
public class ReadCommond implements Command {

	private final PersonDataStore store;

	private final ParserContext context;

	private final MessageFormatter formatter;

	public ReadCommond(final PersonDataStore store, final ParserContext context, final MessageFormatter formatter) {
		this.context = context;
		this.store = store;
		this.formatter = formatter;
	}

	@Override
	public String execute() {
		final String name = context.getPersonName();
		final Person person = store.getPerson(name);

		final StringBuilder sb = new StringBuilder();
		for (final Message msg : person.getTimelineMessages()) {
			sb.append(formatter.format(msg));
		}

		return "\nTimeline: " + name + "\n" + sb.toString();
	}
}
