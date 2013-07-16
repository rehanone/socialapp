package com.bjss.apps.socialgraph.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.message.formatter.MessageFormatter;
import com.bjss.apps.socialgraph.store.PersonDataStore;

/**
 * Creates the command object from the context
 * 
 * @author rehan.mahmood
 * 
 */
@Component
public class CommandFactory {

	private final PersonDataStore store;

	private final MessageFormatter timelineFormatter;

	private final MessageFormatter wallFormatter;

	@Autowired
	public CommandFactory(final PersonDataStore store,
			@Qualifier("timelineMessageFormatter") final MessageFormatter timelineFormatter,
			@Qualifier("wallMessageFormatter") final MessageFormatter wallFormatter) {
		super();
		this.store = store;
		this.timelineFormatter = timelineFormatter;
		this.wallFormatter = wallFormatter;
	}

	public Command getCommand(final ParserContext context) {
		switch (context.getType()) {
		case READ:
			return new ReadCommond(store, context, timelineFormatter);
		case FOLLOW:
			return new FollowCommond(store, context);
		case WALL:
			return new WallCommond(store, context, wallFormatter);
		case MESSAGE:
			return new MessageCommand(store, context);
		case UNKNOWN:
		default:
			throw new UnsupportedOperationException("Unknown command");
		}
	}
}
