package com.bjss.apps.socialgraph.command;

/**
 * CommandParser converts a user provided string to an executable command.
 * 
 * @author rehan.mahmood
 * 
 */
public interface CommandParser {

	Command parse(String cmd);
}
