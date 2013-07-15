package com.bjss.apps.socialgraph.utils;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Assert;
import org.junit.Test;

public class SocialPeriodFormatterTest {

	@Test
	public void testYear() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusYears(1);

		final Period result = new Period(past, now);

		Assert.assertEquals("1 year", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testYears() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusYears(2);

		final Period result = new Period(past, now);

		Assert.assertEquals("2 years", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testMonth() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusMonths(1);

		final Period result = new Period(past, now);

		Assert.assertEquals("1 month", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testMonths() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusMonths(2);

		final Period result = new Period(past, now);

		Assert.assertEquals("2 months", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testDay() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusDays(1);

		final Period result = new Period(past, now);

		Assert.assertEquals("1 day", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testDays() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusDays(2);

		final Period result = new Period(past, now);

		Assert.assertEquals("2 days", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testHour() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusHours(1);

		final Period result = new Period(past, now);

		Assert.assertEquals("1 hour", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testHours() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusHours(2);

		final Period result = new Period(past, now);

		Assert.assertEquals("2 hours", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testMinute() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusMinutes(1);

		final Period result = new Period(past, now);

		Assert.assertEquals("1 minute", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testMinutes() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusMinutes(2);

		final Period result = new Period(past, now);

		Assert.assertEquals("2 minutes", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testSecond() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusSeconds(1);

		final Period result = new Period(past, now);

		Assert.assertEquals("1 second", SocialPeriodFormatter.toString(result));
	}

	@Test
	public void testSeconds() {
		final DateTime now = new DateTime();
		final DateTime past = now.minusSeconds(2);

		final Period result = new Period(past, now);

		Assert.assertEquals("2 seconds", SocialPeriodFormatter.toString(result));
	}
}
