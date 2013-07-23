package com.bjss.apps.socialgraph;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjss.apps.socialgraph.command.CommandExecutor;
import com.bjss.apps.socialgraph.reader.InputReader;

@RunWith(MockitoJUnitRunner.class)
public class AppOrchestratorTest {

	@Mock
	private InputReader inputReader;

	@Mock
	private CommandExecutor commandExecutor;

	private AppOrchestrator appOrchestrator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		appOrchestrator = new AppOrchestrator(inputReader, commandExecutor);

	}

	@Test(timeout = 1000)
	public void should_not_execute_exit_command() {
		final String command = "exit";

		when(inputReader.readLine()).thenReturn(command);

		appOrchestrator.run();

		verifyZeroInteractions(commandExecutor);
	}
}
