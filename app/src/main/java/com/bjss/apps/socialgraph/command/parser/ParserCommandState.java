package com.bjss.apps.socialgraph.command.parser;

import static com.bjss.apps.socialgraph.command.parser.ParserConstents.FOLLOWS;
import static com.bjss.apps.socialgraph.command.parser.ParserConstents.MESSAGE;
import static com.bjss.apps.socialgraph.command.parser.ParserConstents.WALL;

public class ParserCommandState implements ParserState {

	@Override
	public ParserState parse(final String token, final ParserContext context) {
		if (MESSAGE.equals(token)) {
			context.setType(CommandType.MESSAGE);
			return new ParserMessageState();
		} else if (FOLLOWS.equals(token)) {
			context.setType(CommandType.FOLLOW);
			return new ParserFollowsState();
		} else if (WALL.equals(token)) {
			context.setType(CommandType.WALL);
			return new ParserStopState();
		} else {
			return new ParserStopState();
		}
	}
}
