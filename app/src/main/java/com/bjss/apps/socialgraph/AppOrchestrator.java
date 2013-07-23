package com.bjss.apps.socialgraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjss.apps.socialgraph.command.CommandExecutor;
import com.bjss.apps.socialgraph.reader.InputReader;

@Component
public class AppOrchestrator {

	private final InputReader inputReader;

	private final CommandExecutor commandExecutor;

	@Autowired
	public AppOrchestrator(final InputReader inputReader, final CommandExecutor commandExecutor) {
		super();
		this.inputReader = inputReader;
		this.commandExecutor = commandExecutor;
	}

	public void run() {
		String curLine = "";
		do {
			curLine = inputReader.readLine();

			if (curLine.equals("exit")) {
				break;
			}
			commandExecutor.run(curLine);
		} while (true);
	}
}
