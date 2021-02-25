package com.ensa.SmartSchoolServer.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.SmartSchoolServer.service.StudentService;
import com.ensa.SmartSchoolServer.entity.Student;

@RestController
@RequestMapping(value="/student",method= {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/create",method=RequestMethod.POST)
	@ResponseBody
	public Student create(@RequestBody Student student) {
		return studentService.create(student);
	}
	

	@RequestMapping(value = "/updateStudent",method=RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	@RequestMapping(value = "/updateEmail/email={email}",method=RequestMethod.PUT)
	public Student updateStudentEmail(@RequestBody Student student,@PathVariable(name="email") String email) {
		return studentService.updatePassword(student, email);
	}
	
	@RequestMapping(value = "/updatePassword/password={password}",method=RequestMethod.PUT)
	public Student updateStudentPassword(@RequestBody Student student,@PathVariable(name="password") String password) {
		return studentService.updatePassword(student, password);
	}
	
	@RequestMapping(value = "/updatePhoneNumber/phoneNumber={phoneNumber}",method=RequestMethod.PUT)
	public Student updateStudentPhoneNumber(@RequestBody Student student,@PathVariable(name="phoneNumber") String phoneNumber) {
		return studentService.updatePhoneNumber(student, phoneNumber);
	}
	
	@RequestMapping(value = "/updateMaxAttempts",method=RequestMethod.PUT)
	public Student updateMaxAttempts(@RequestBody Student student) {
		return studentService.updateMaxAttempts(student);
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	public Student delete(@RequestBody Student student) {
		return studentService.delete(student);
	}
	
	@RequestMapping(value = "/getStudent/id={id}",method=RequestMethod.POST)
	@ResponseBody
	public Student getStudent(@PathVariable(name="id") int id) {
		return studentService.getStudentById(id);
	}
	
	
	
	@RequestMapping(value="/getStudents", method=RequestMethod.GET)
	@ResponseBody
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	
	
	@RequestMapping(value = "/getStudentByEmail",method=RequestMethod.POST)
	@ResponseBody
	public Student getStudentbyemail(@RequestBody String email) {
		return studentService.getStudentByEmail(email);
	}
	
	
}
