package com.bjss.apps.socialgraph.command.parser;

import org.apache.commons.lang3.StringUtils;

public class ParserFollowsState implements ParserState {

	@Override
	public ParserState parse(final String token, final ParserContext context) {
		if (StringUtils.isAlphanumeric(token)) {
			context.setSecondPersonName(token);
			return new ParserStopState();
		}
		throw new ParserException("Valid username must be alphanumaric");
	}
}
