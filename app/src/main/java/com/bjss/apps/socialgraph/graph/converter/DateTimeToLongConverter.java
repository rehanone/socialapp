package com.bjss.apps.socialgraph.graph.converter;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

public class DateTimeToLongConverter implements Converter<DateTime, Long> {
	@Override
	public Long convert(final DateTime dateTime) {
		return dateTime.getMillis();
	}
}