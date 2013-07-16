package com.bjss.apps.socialgraph;

/**
 * main application runner
 * 
 * @author rehan.mahmood
 * 
 */
public class App {

	public static void main(final String[] args) throws InterruptedException {

		final SocialOrchestrator orchestrator = new SocialOrchestrator();

		orchestrator.run("Alice -> I love the weather today");
		Thread.sleep(6400);
		orchestrator.run("Bob -> Oh, we lost!");
		Thread.sleep(8900);
		orchestrator.run("Bob -> at least it's sunny");
		Thread.sleep(12000);
		orchestrator.run("Alice");
		orchestrator.run("Bob");
		orchestrator.run("Charlie -> I'm in New York today! Anyone wants to have a coffee?");
		orchestrator.run("Charlie follows Alice");
		orchestrator.run("Charlie wall");
		orchestrator.run("Charlie follows Bob");
		orchestrator.run("Charlie wall");
		orchestrator.run("Alice -> Just testing");
		orchestrator.run("Alice wall");
		orchestrator.run("Charlie wall");
		orchestrator.run("Bob follows Alice");
		orchestrator.run("Bob wall");
	}
}
