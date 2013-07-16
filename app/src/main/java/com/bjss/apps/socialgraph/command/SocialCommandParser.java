package com.bjss.apps.socialgraph.command;

import static com.bjss.apps.socialgraph.command.parser.ParserConstents.TOKEN_SEPARATOR;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.command.parser.ParserFactory;
import com.bjss.apps.socialgraph.command.parser.ParserState;

/**
 * 
 * Parse the input string and returns an executable command object.
 * 
 * @author rehan.mahmood
 * 
 */
@Component
public class SocialCommandParser implements CommandParser {

	private final CommandFactory commandFactory;

	private final ParserFactory parserFactory;

	@Autowired
	public SocialCommandParser(final CommandFactory commandFactory, final ParserFactory parserContextFactory) {
		super();
		this.parserFactory = parserContextFactory;
		this.commandFactory = commandFactory;
	}

	@Override
	public Command parse(final String cmd) {
		final String[] contents = cmd.split(TOKEN_SEPARATOR);

		final ParserContext context = parserFactory.createContext();
		ParserState state = parserFactory.createStartState();

		for (final String token : contents) {
			// skip blank tokens
			if (StringUtils.isBlank(token)) {
				continue;
			}

			state = state.parse(token, context);
		}

		return commandFactory.getCommand(context);
	}
}
