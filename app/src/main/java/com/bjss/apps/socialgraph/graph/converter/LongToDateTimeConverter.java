package com.bjss.apps.socialgraph.graph.converter;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

public class LongToDateTimeConverter implements Converter<Long, DateTime> {
	@Override
	public DateTime convert(final Long millis) {
		return new DateTime(millis);
	}
}