package com.bjss.apps.socialgraph.formatter;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 * SocialPeriodFormatter class provides utility method for pretty printing a time period as age of a
 * social update.
 * 
 * @author rehan
 * 
 */
public class SocialPeriodFormatter {

	/**
	 * Formats Period objects in social update friendly format.
	 * 
	 * @param period
	 * @return String
	 */
	public static String toString(final Period period) {
		final PeriodFormatter pf = getFormatter();
		return pf.print(period);
	}

	/**
	 * Provides formatter for Joda-Time Period objects to format them in social update friendly
	 * format.
	 * 
	 * @return PeriodFormatter
	 */
	private static PeriodFormatter getFormatter() {
		return new PeriodFormatterBuilder().appendYears().appendSuffix(" year", " years").appendSeparator(" and ")
				.printZeroRarelyLast().appendMonths().appendSuffix(" month", " months").appendSeparator(" and ")
				.printZeroRarelyLast().appendDays().appendSuffix(" day", " days").appendSeparator(" and ")
				.printZeroRarelyLast().appendHours().appendSuffix(" hour", " hours").appendSeparator(" and ")
				.printZeroRarelyLast().appendMinutes().appendSuffix(" minute", " minutes").appendSeparator(" and ")
				.printZeroRarelyLast().appendSeconds().appendSuffix(" second", " seconds").toFormatter();
	}
}
