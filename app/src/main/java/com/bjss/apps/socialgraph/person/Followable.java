package com.bjss.apps.socialgraph.person;

import com.bjss.apps.socialgraph.message.Message;

/**
 * Followable interface defines the ability of an entity to register other interested entities and
 * allow them to subscribe for its updates.
 * 
 * @author rehan.mahmood
 * 
 */
public interface Followable {

	void addFollower(Follower follower);

	void publishUpdate(Message msg);
}
