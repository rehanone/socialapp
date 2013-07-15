package com.bjss.apps.socialgraph;

import com.bjss.apps.socialgraph.person.Person;

public class App {

	public static void main(final String[] args) throws InterruptedException {

		final Person alice = new Person("Alice");
		alice.postMessage("I love the weather today");
		Thread.sleep(6400);

		final Person bob = new Person("Bob");
		bob.postMessage("Oh, we lost!");
		Thread.sleep(8900);
		bob.postMessage("at least it's sunny");

		Thread.sleep(12000);

		System.out.println(alice);
		System.out.println(bob);
	}
}
