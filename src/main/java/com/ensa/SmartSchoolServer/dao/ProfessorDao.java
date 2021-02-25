package com.ensa.SmartSchoolServer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchoolServer.entity.Professor;
import com.ensa.SmartSchoolServer.mappers.ProfessorMapper;

@Component
public class ProfessorDao {
	
JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProfessorDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Professor> getProfessors() {	
		return jdbcTemplate.query("select * from professor", new ProfessorMapper());
	}
	
	public Professor getProfessorByFirstName(String firstName) {
		return jdbcTemplate.queryForObject("select * from professor where professor_first_name=?",new ProfessorMapper(),firstName);	
	}
	public Professor getProfessorByLastName(String lastName) {
		return jdbcTemplate.queryForObject("select * from professor where professor_last_name=?",new ProfessorMapper(),lastName);	
	}
	
public Professor updateProfessorFirstName(Professor professor,String firstName) {
		String sql="UPDATE professor SET PROFESSOR_FIRST_NAME=? WHERE PROFESSOR_ID=?";
		jdbcTemplate.update(sql,firstName,professor.getProfessorId());
		return professor;
	}
	
	public Professor updateProfessorLastName(Professor professor,String lastName) {
		String sql="UPDATE professor SET PROFESSOR_LAST_NAME=? WHERE PROFESSOR_ID=?";
		jdbcTemplate.update(sql,lastName,professor.getProfessorId());
		return professor;
	}
	
	public Professor updatePassword(Professor professor,String password) {
		String sql="UPDATE professor SET PASSWORD=? WHERE PROFESSOR_ID=?";
		jdbcTemplate.update(sql,password,professor.getProfessorId());
		return professor;
	}
	
	
	public Professor delete(Professor professor) {
		String sql="DELETE FROM PROFESSOR WHERE PROFESSOR_ID=?";
		jdbcTemplate.update(sql,professor.getProfessorId());
		return professor;
	}
	public Professor create(Professor professor) {
		String sql="INSERT INTO professor (professor_first_name,professor_last_name,level_name,password) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,professor.getProfessorFirstName(),professor.getProfessorLastName(),professor.getLevelName(),professor.getPassword());
		return professor;	
	}
	
	public Professor update(Professor professor) {
		String sql="UPDATE PROFESSOR SET professor_first_name =?,professor_last_name =?,level_name=?,password=? WHERE PROFESSOR_ID=?";
		jdbcTemplate.update(sql,professor.getProfessorFirstName(),professor.getProfessorLastName(),professor.getLevelName(),professor.getPassword(),professor.getProfessorId());
		return professor;
	}
}
