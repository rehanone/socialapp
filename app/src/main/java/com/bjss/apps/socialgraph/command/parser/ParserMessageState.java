package com.bjss.apps.socialgraph.command.parser;

public class ParserMessageState implements ParserState {

	@Override
	public ParserState parse(final String token, final ParserContext context) {
		context.appendMessage(token);
		// This will allow reading of all words in the message.
		return this;
	}
}
