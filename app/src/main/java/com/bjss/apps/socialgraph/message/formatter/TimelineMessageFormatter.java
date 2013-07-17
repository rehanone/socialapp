package com.bjss.apps.socialgraph.message.formatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.bjss.apps.socialgraph.formatter.SocialPeriodFormatter;
import com.bjss.apps.socialgraph.graph.entity.Message;

/**
 * TimelineMessageFormatter class provides formating to the message, appropriate for a social
 * timeline.
 * 
 * @author rehan.mahmood
 * 
 */
@Component
public class TimelineMessageFormatter implements MessageFormatter {

	/**
	 * Returns message in a pretty printed string for timeline.
	 */
	@Override
	public String format(final Message message) {
		final String age = SocialPeriodFormatter.toString(message.getAge());
		if (StringUtils.isBlank(age)) {
			return String.format("\n %s (moments ago)", message.getMessage());
		} else {
			return String.format("\n %s (%s ago)", message.getMessage(), age);
		}
	}
}
