package com.ensa.SmartSchoolServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.SmartSchoolServer.entity.ForumMessage;

import com.ensa.SmartSchoolServer.service.ForumMessageService;

@RestController
@RequestMapping(value="/forumMessage", method= {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class ForumMessageController {

	@Autowired
	private ForumMessageService forumMessageService;
	
	@RequestMapping(value="/getForumMessages",method=RequestMethod.GET)
	public List<ForumMessage> getForumMessages(){
		return forumMessageService.getForumMessages();
	}
	
	@RequestMapping(value="/getForumMessage/id={id}",method=RequestMethod.POST)
	@ResponseBody
	public ForumMessage getForumMessage(@PathVariable(name="id") int id) {
		
		return forumMessageService.getForumMessageById(id);
	}
	
	@RequestMapping(value ="/create",method=RequestMethod.POST)
	@ResponseBody
	public ForumMessage create(@RequestBody ForumMessage forumMessage) {
		return forumMessageService.create(forumMessage);
	}
	
	@RequestMapping(value = "/updateTopic/topic={topic}",method=RequestMethod.PUT)
	public ForumMessage updateTopic(@RequestBody ForumMessage forumMessage,@PathVariable(name="topic") String topic) {
		return forumMessageService.updateTopic(forumMessage, topic);
	}
	 
	@RequestMapping(value = "/updateContent/content={content}",method=RequestMethod.PUT)
	public ForumMessage updateContent(@RequestBody ForumMessage forumMessage,@PathVariable(name="content") String content) {
		return forumMessageService.updateContent(forumMessage, content);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ForumMessage delete(@RequestBody ForumMessage forumMessage) {
		return forumMessageService.delete(forumMessage);
	}
	
	
}
