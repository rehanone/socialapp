package com.bjss.apps.socialgraph.command.parser;

public class ParserStopState implements ParserState {

	@Override
	public ParserState parse(final String token, final ParserContext context) {
		// No more token should be processed in this state
		return this;
	}
}
