package com.bjss.apps.socialgraph.utils;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class SocialPeriodFormatter {

	public static String toString(final Period period) {
		final PeriodFormatter pf = getFormatter();
		return pf.print(period);
	}

	private static PeriodFormatter getFormatter() {
		return new PeriodFormatterBuilder().appendYears().appendSuffix(" year", " years").appendSeparator(" and ")
				.printZeroRarelyLast().appendMonths().appendSuffix(" month", " months").appendSeparator(" and ")
				.printZeroRarelyLast().appendDays().appendSuffix(" day", " days").appendSeparator(" and ")
				.printZeroRarelyLast().appendHours().appendSuffix(" hour", " hours").appendSeparator(" and ")
				.printZeroRarelyLast().appendMinutes().appendSuffix(" minute", " minutes").appendSeparator(" and ")
				.printZeroRarelyLast().appendSeconds().appendSuffix(" second", " seconds").toFormatter();
	}
}
