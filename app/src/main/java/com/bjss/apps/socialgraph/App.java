package com.bjss.apps.socialgraph;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * main application runner
 * 
 * @author rehan.mahmood
 * 
 */
public class App {

	public static void main(final String[] args) throws InterruptedException {

		final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		final AppOrchestrator orchestrator = (AppOrchestrator) context.getBean("appOrchestrator");

		orchestrator.run();
	}
}
