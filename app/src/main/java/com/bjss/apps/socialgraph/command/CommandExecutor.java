package com.bjss.apps.socialgraph.command;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjss.apps.socialgraph.command.Command;
import com.bjss.apps.socialgraph.command.CommandParser;

@Component
public class CommandExecutor {

	private final CommandParser parser;

	@Autowired
	public CommandExecutor(final CommandParser parser) {
		super();
		this.parser = parser;
	}

	public void run(final String cmd) {
		try {
			final Command command = parser.parse(cmd);
			final String output = command.execute();
			if (!StringUtils.isBlank(output)) {
				System.out.println(output);
			}
		} catch (final Throwable e) {
			System.out.println("Invalid command: " + cmd);
		}
	}
}
