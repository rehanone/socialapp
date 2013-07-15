package com.bjss.apps.socialgraph.person;

import com.bjss.apps.socialgraph.message.Message;

/**
 * Follower interface defines the ability of an entity to follow other entities and receives updates
 * on them.
 * 
 * @author rehan.mahmood
 * 
 */
public interface Follower {

	void update(Message msg);
}
