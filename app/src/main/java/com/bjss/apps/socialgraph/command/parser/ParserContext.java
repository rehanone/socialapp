package com.bjss.apps.socialgraph.command.parser;

public class ParserContext {
	private CommandType type = CommandType.UNKNOWN;

	private String personName;

	private final StringBuilder message = new StringBuilder();

	private String secondPersonName;

	public CommandType getType() {
		return type;
	}

	public void setType(final CommandType type) {
		this.type = type;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(final String personName) {
		this.personName = personName;
	}

	public String getMessage() {
		return message.toString();
	}

	public void appendMessage(final String token) {
		this.message.append(token + " ");
	}

	public String getSecondPersonName() {
		return secondPersonName;
	}

	public void setSecondPersonName(final String secondPersonName) {
		this.secondPersonName = secondPersonName;
	}
}
