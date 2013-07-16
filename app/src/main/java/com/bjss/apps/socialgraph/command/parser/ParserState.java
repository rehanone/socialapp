package com.bjss.apps.socialgraph.command.parser;

/**
 * Interface for parsing states
 * 
 * @author rehan.mahmood
 * 
 */
public interface ParserState {

	ParserState parse(String token, ParserContext context);
}
