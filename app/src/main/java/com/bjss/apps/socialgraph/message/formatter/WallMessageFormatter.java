package com.bjss.apps.socialgraph.message.formatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.bjss.apps.socialgraph.formatter.SocialPeriodFormatter;
import com.bjss.apps.socialgraph.graph.entity.Message;

/**
 * Wall class provides formating to the messages aggregate, appropriate for a social wall.
 * 
 * @author rehan.mahmood
 * 
 */
@Component
public class WallMessageFormatter implements MessageFormatter {

	/**
	 * Returns message in a pretty printed string.
	 */
	@Override
	public String format(final Message message) {
		final String age = SocialPeriodFormatter.toString(message.getAge());
		if (StringUtils.isBlank(age)) {
			return String.format("\n %s - %s (moments ago)", message.getOwner().getName(), message.getMessage());
		} else {
			return String.format("\n %s - %s (%s ago)", message.getOwner().getName(), message.getMessage(), age);
		}
	}
}
