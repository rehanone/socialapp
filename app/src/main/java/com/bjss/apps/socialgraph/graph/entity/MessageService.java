package com.bjss.apps.socialgraph.graph.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public Message findById(final Long id) {
		return messageRepository.findOne(id);
	}

	public Message save(final Message message) {
		return messageRepository.save(message);
	}
}
