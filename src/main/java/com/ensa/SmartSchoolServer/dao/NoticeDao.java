package com.ensa.SmartSchoolServer.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchoolServer.entity.Notice;
import com.ensa.SmartSchoolServer.mappers.NoticeMapper;

@Component
public class NoticeDao {

JdbcTemplate jdbcTemplate;
	
	@Autowired
	public NoticeDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Notice> getNotices() {
		return jdbcTemplate.query("SELECT * FROM NOTICE", new NoticeMapper());
	}
	
	public Notice getNoticeByTitle(String title) {
		String sql = "SELECT * FROM NOTICE WHERE TITLE=?";
		return jdbcTemplate.queryForObject(sql, new NoticeMapper(), title);
	}

	
	public Notice getNoticeByPublicationDate(String publicationDate) {
		String sql = "SELECT * FROM NOTICE WHERE PUBLICATION_DATE=?";
		return jdbcTemplate.queryForObject(sql, new NoticeMapper(), publicationDate);
	}
	
	public Notice create(Notice notice) {
		String sql = "INSERT INTO NOTICE(title, publication_date, message) VALUES(?, ?, ?)";
		System.out.println(jdbcTemplate.update(sql, notice.getTitle(), notice.getPublicationDate(), notice.getMessage()));
		return notice;
	}
	
	public Notice updateMessage(Notice notice, String message) {
		String sql = "UPDATE NOTICE SET MESSAGE=? WHERE NOTICE_ID=?";
		jdbcTemplate.update(sql, message, notice.getNoticeId());
		return notice;
	}
	
	public Notice updateTitle(Notice notice, String title) {
		String sql = "UPDATE NOTICE SET TITLE=? WHERE NOTICE_ID=?";
		jdbcTemplate.update(sql, title, notice.getNoticeId());
		return notice;
	}
	
	public Notice updatePublicationDate(Notice notice, String date) {
		String sql = "UPDATE NOTICE SET PUBLICATION_DATE=? WHERE NOTICE_ID=?";
		jdbcTemplate.update(sql, date, notice.getNoticeId());
		return notice;
	}
	
	public Notice delete(Notice notice) {
		String sql="DELETE FROM NOTICE WHERE NOTICE_ID=?";
		jdbcTemplate.update(sql, notice.getNoticeId());
		return notice;
	
}}
