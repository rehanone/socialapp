package com.bjss.apps.socialgraph;

import com.bjss.apps.socialgraph.command.Command;
import com.bjss.apps.socialgraph.command.CommandParser;
import com.bjss.apps.socialgraph.command.SocialCommandParser;

public class SocialOrchestrator {

	final CommandParser parser = new SocialCommandParser();

	public void run(final String cmd) {
		try {
			final Command command = parser.parse(cmd);
			final String output = command.execute();
			System.out.println(output);
		} catch (final Throwable e) {
			System.out.println("Invalid command: " + cmd);
		}
	}
}
