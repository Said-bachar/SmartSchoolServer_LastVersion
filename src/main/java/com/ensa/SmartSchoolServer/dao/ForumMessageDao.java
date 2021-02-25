package com.ensa.SmartSchoolServer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchoolServer.entity.ForumMessage;

import com.ensa.SmartSchoolServer.mappers.ForumMessageMapper;

@Component
public class ForumMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ForumMessage create(ForumMessage forumMessage) {
		
		String sql="INSERT INTO FORUM_MESSAGE(content,message_writer,topic,pub_date) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, forumMessage.getContent(), forumMessage.getMessageWriter(), forumMessage.getTopic(),forumMessage.getPubDate());
		return forumMessage;
	}

	public List<ForumMessage> getForumMessages() {
		return jdbcTemplate.query("SELECT * FROM FORUM_MESSAGE", new ForumMessageMapper());
	}
 
	public ForumMessage getForumMessageById(int id) {
		String sql = "SELECT * FROM FORUM_MESSAGE WHERE FORUM_MESSAGE_ID=?";
		return jdbcTemplate.queryForObject(sql, new ForumMessageMapper(), id);
	}
	
	public ForumMessage updateContent(ForumMessage forumMessage, String content) {
		String sql = "UPDATE FORUM_MESSAGE SET CONTENT=? WHERE FORUM_MESSAGE_ID=?";
		jdbcTemplate.update(sql, content, forumMessage.getId());
		return forumMessage;
	}
	
	public ForumMessage updateTopic(ForumMessage forumMessage, String topic) {
		String sql = "UPDATE FORUM_MESSAGE SET TOPIC=? WHERE FORUM_MESSAGE_ID=?";
		jdbcTemplate.update(sql, topic, forumMessage.getId());
		return forumMessage;
	}

	public ForumMessage delete(ForumMessage forumMessage) {
		String sql = "DELETE FROM FORUM_MESSAGE WHERE FORUM_MESSAGE_ID=?";
		jdbcTemplate.update(sql,forumMessage.getId());
		return forumMessage;
	}

}
