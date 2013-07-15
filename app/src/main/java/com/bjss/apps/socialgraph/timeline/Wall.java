package com.bjss.apps.socialgraph.timeline;

import org.apache.commons.lang3.StringUtils;

import com.bjss.apps.socialgraph.message.Message;
import com.bjss.apps.socialgraph.utils.SocialPeriodFormatter;

/**
 * Wall class provides formating to the messages aggregate, appropriate for a social wall.
 * 
 * @author rehan.mahmood
 * 
 */
public class Wall extends AbstractMessageAggregator {

	/**
	 * Returns all messages in the aggregate in a pretty printed string.
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for (final Message msg : getMessages()) {
			final String age = SocialPeriodFormatter.toString(msg.getAge());
			if (StringUtils.isBlank(age)) {
				sb.append(String.format("\n %s - %s (moments ago)", msg.getOwner().getName(), msg.getMessage()));
			} else {
				sb.append(String.format("\n %s - %s (%s ago)", msg.getOwner().getName(), msg.getMessage(), age));
			}
		}
		return sb.toString();
	}
}
