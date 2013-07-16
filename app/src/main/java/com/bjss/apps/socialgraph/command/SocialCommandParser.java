package com.bjss.apps.socialgraph.command;

import static com.bjss.apps.socialgraph.command.parser.ParserConstents.TOKEN_SEPARATOR;

import org.apache.commons.lang3.StringUtils;

import com.bjss.apps.socialgraph.command.parser.ParserContext;
import com.bjss.apps.socialgraph.command.parser.ParserStartState;
import com.bjss.apps.socialgraph.command.parser.ParserState;

/**
 * 
 * Parse the input string and returns an executable command object.
 * 
 * @author rehan
 * 
 */
public class SocialCommandParser implements CommandParser {

	private final CommandFactory commandFactory = new CommandFactory();

	@Override
	public Command parse(final String cmd) {
		final String[] contents = cmd.split(TOKEN_SEPARATOR);

		final ParserContext context = new ParserContext();
		ParserState state = new ParserStartState();

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
