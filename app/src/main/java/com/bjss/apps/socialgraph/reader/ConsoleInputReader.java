package com.bjss.apps.socialgraph.reader;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleInputReader implements InputReader {

	private final BufferedReader reader;

	@Autowired
	public ConsoleInputReader(final BufferedReader bufferedReader) {
		this.reader = bufferedReader;
	}

	@Override
	public String readLine() {

		try {
			System.out.print("> ");
			return reader.readLine();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
