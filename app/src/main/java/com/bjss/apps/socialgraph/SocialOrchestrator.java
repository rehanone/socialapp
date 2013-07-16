package com.bjss.apps.socialgraph;

import org.apache.commons.lang3.StringUtils;

import com.bjss.apps.socialgraph.command.Command;
import com.bjss.apps.socialgraph.command.CommandParser;
import com.bjss.apps.socialgraph.command.SocialCommandParser;

public class SocialOrchestrator {

	final CommandParser parser = new SocialCommandParser();

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
