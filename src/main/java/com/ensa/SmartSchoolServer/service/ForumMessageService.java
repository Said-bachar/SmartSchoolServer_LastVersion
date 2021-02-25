package com.ensa.SmartSchoolServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchoolServer.dao.ForumMessageDao;
import com.ensa.SmartSchoolServer.entity.ForumMessage;


@Component
public class ForumMessageService {

	@Autowired
	private ForumMessageDao forumMessageDao;
	
	public ForumMessage create(ForumMessage forumMessage) {
		
		return forumMessageDao.create(forumMessage);
	}
	
	public List<ForumMessage> getForumMessages(){
		return forumMessageDao.getForumMessages();
	}
	
	public ForumMessage getForumMessageById(int id) {
		
		return forumMessageDao.getForumMessageById(id);
	}
	
	public ForumMessage delete(ForumMessage forumMessage) {
		return forumMessageDao.delete(forumMessage);
	}
	
	public ForumMessage updateTopic(ForumMessage forumMessage, String title) {
		return forumMessageDao.updateTopic(forumMessage, title);
	}
	
	public ForumMessage updateContent(ForumMessage forumMessage, String content) {
		return forumMessageDao.updateContent(forumMessage, content);
	}
}
