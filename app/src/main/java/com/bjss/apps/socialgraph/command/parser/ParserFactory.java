package com.bjss.apps.socialgraph.command.parser;

import org.springframework.stereotype.Component;

@Component
public class ParserFactory {

	public ParserContext createContext() {
		return new ParserContext();
	}

	public ParserState createStartState() {
		return new ParserStartState();
	}
}
