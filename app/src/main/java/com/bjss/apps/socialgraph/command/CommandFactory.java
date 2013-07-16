package com.bjss.apps.socialgraph.command;

import com.bjss.apps.socialgraph.command.parser.ParserContext;

/**
 * Creates the command object from the context
 * 
 * @author rehan.mahmood
 * 
 */
public class CommandFactory {

	public Command getCommand(final ParserContext context) {
		switch (context.getType()) {
		case READ:
			return new ReadCommond(context);
		case FOLLOW:
			return new FollowCommond(context);
		case WALL:
			return new WallCommond(context);
		case MESSAGE:
			return new MessageCommand(context);
		case UNKNOWN:
		default:
			throw new UnsupportedOperationException("Unknown command");
		}
	}
}
