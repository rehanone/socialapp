package com.bjss.apps.socialgraph.graph.converter;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

public class DateTimeToStringConverter implements Converter<DateTime, String> {

	@Override
	public String convert(final DateTime source) {
		return source.toString();
	}
}