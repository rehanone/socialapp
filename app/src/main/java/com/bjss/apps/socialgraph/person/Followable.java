package com.bjss.apps.socialgraph.person;

import java.util.Set;

import com.bjss.apps.socialgraph.message.Message;

public interface Followable {

	Set<Message> getMessages();
}
