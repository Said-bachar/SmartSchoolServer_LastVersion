package com.ensa.SmartSchoolServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.SmartSchoolServer.entity.Notice;
import com.ensa.SmartSchoolServer.service.NoticeService;

@RestController
@RequestMapping(value="/notice",method= {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/getNotices",method=RequestMethod.GET)
	public List<Notice> getNotices() {
		return noticeService.getNotices();
	}
	
	@RequestMapping(value = "/getNoticeByTitle/title={title}",method=RequestMethod.POST)
	public Notice getNoticeByTitle(@PathVariable String title) {
		return noticeService.getNoticeByTitle(title);
	}
	
	@RequestMapping(value = "/getNoticeByPublicationDate/date={publicationDate}",method=RequestMethod.POST)
	public Notice getNoticeByPublicationDate(@PathVariable(name="publicationDate") String publicationDate) {
		return noticeService.getNoticeByPublicationDate(publicationDate);
	}
	
	@RequestMapping(value = "/updateTitle/title={title}",method=RequestMethod.PUT)
	public Notice updateTitle(@RequestBody Notice notice,@PathVariable(name="title") String title) {
		return noticeService.updateTitle(notice,title);
	}
	 
	@RequestMapping(value = "/updateMessage/message={message}",method=RequestMethod.PUT)
	public Notice updateMessage(@RequestBody Notice notice,@PathVariable(name="message") String message) {
		return noticeService.updateMessage(notice,message);
	}
	
	@RequestMapping(value = "/updatePublicationDate/date={date}",method=RequestMethod.PUT)
	public Notice updatePublicationDate(@RequestBody Notice notice,@PathVariable(name="date") String date) {
		return noticeService.updatePublicationDate(notice, date);
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	public Notice delete(@RequestBody Notice notice) {
		return noticeService.delete(notice);
	}
	
	@RequestMapping(value = "/create",method=RequestMethod.POST)
	public Notice create(@RequestBody Notice notice) {
		return noticeService.create(notice);
	}
	
}
