package com.bjss.apps.socialgraph.command.parser;

import org.apache.commons.lang3.StringUtils;

/**
 * Initial parser state
 * 
 * @author rehan.mahmood
 * 
 */
public class ParserStartState implements ParserState {

	@Override
	public ParserState parse(final String token, final ParserContext context) {

		if (StringUtils.isAlphanumeric(token)) {
			context.setType(CommandType.READ);
			context.setPersonName(token);
			return new ParserCommandState();
		}
		throw new ParserException("Valid username must be alphanumaric");
	}
}
