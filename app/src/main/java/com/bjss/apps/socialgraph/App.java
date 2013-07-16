package com.bjss.apps.socialgraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * main application runner
 * 
 * @author rehan.mahmood
 * 
 */
public class App {

	private final static SocialOrchestrator orchestrator = new SocialOrchestrator();

	public static void main(final String[] args) throws InterruptedException {

		final InputStreamReader converter = new InputStreamReader(System.in);
		final BufferedReader in = new BufferedReader(converter);

		String curLine = "";
		while (!(curLine.equals("exit"))) {
			try {
				System.out.print("> ");
				curLine = in.readLine();
			} catch (final IOException e) {
				e.printStackTrace();
			}
			if (!(curLine.equals("exit"))) {
				orchestrator.run(curLine);
			}
		}
	}
}
