package com.ensa.SmartSchoolServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchoolServer.dao.StudentDao;
import com.ensa.SmartSchoolServer.entity.Student;

@Component
public class StudentService {

	private StudentDao studentDao;

	@Autowired
	public StudentService(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	public List<Student> getStudents() {

		return this.studentDao.getStudents();
	}

	public Student getStudent(String firstName, String lastName) {
		return this.studentDao.getStudent(firstName, lastName);
	}

	public Student create(Student student) {

		return studentDao.create(student);
	}

	public Student updateEmail(Student student, String email) {

		return studentDao.updateEmail(student, email);
	}

	public Student updatePhoneNumber(Student student, String phoneNumber) {

		return studentDao.updatePhoneNumber(student, phoneNumber);
	}

	public Student updatePassword(Student student, String password) {

		return studentDao.updatePassword(student, password);
	}
	public Student delete(Student student) {
		return studentDao.delete(student);
	}
	
	public List<Student> read() {
		return studentDao.read();
	}
	
        public boolean authenticate(String email, String password) {
		
		Student student = studentDao.getStudentByEmail(email);
		
		if(student.equals(null)) {
			return false;
		}
		return student.getPassword().equals(password) ;
	}
        
        public Student getStudentByEmail(String email) {
    		return studentDao.getStudentByEmail(email);
    	}
        
        public Student updateMaxAttempts(Student student) {
        	return studentDao.updateMaxAttempts(student);
        }

		public Student getStudentById(int id) {
			
			return studentDao.getStudentById(id);
		}

		public Student updateStudent(Student student) {
			return studentDao.updateStudent(student);
		}

}
