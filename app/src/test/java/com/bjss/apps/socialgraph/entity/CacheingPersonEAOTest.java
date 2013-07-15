package com.bjss.apps.socialgraph.entity;

import org.junit.Assert;
import org.junit.Test;

import com.bjss.apps.socialgraph.person.Person;

public class CacheingPersonEAOTest {

	private static final String BOB = "Bob";

	@Test
	public void test() {
		final Person p = new Person(BOB);
		getStore().save(p);

		Assert.assertEquals(p, getStore().findByName(BOB));

		getStore().remove(BOB);

		Assert.assertNull(getStore().findByName(BOB));
	}

	private CacheingPersonEAO getStore() {
		return CacheingPersonEAO.getInstance();
	}
}
