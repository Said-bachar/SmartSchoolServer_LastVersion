package com.ensa.SmartSchoolServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.SmartSchoolServer.entity.Professor;
import com.ensa.SmartSchoolServer.service.ProfessorService;



@RestController
@RequestMapping(value="/professor",method= {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	
	@RequestMapping(value = "/create",method=RequestMethod.POST)
	@ResponseBody
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorService.create(professor);
	}
	
	@RequestMapping(value = "/getProfessors",method=RequestMethod.GET)
	public List<Professor> getProfessors() {
		return professorService.getProfessors();
	}
	
	@RequestMapping(value = "/getProfessorByFirstName/firstname={firstname}",method=RequestMethod.POST)
	@ResponseBody
	public Professor getProfessorByFirstName(@PathVariable(name="firstname") String firstName) {
		return professorService.getProfessorByFirstName(firstName);
	}
	
	@RequestMapping(value = "/getProfessorByLastName/lastname={lastname}",method=RequestMethod.POST)
	@ResponseBody
	public Professor getProfessorByLastName(@PathVariable(name="lastname") String firstName) {
		return professorService.getProfessorByLastName(firstName);
	}
	
	@RequestMapping(value = "/updateProfessorFirstName/firstname={firstname}",method=RequestMethod.PUT)
	public Professor updateProfessorFirstName(@RequestBody Professor professor, @PathVariable(name="firstname")  String firstName) {
		return professorService.updateProfessorFirstName(professor, firstName);
	}
	
	@RequestMapping(value = "/updateProfessorLastName/lastname={lastname}",method=RequestMethod.PUT)
	public Professor updateProfessorLastName(@RequestBody Professor professor, @PathVariable(name="lastname") String lastName) {
		return professorService.updateProfessorLastName(professor, lastName);
	}
	
	@RequestMapping(value = "/updatePassword/password={password}",method=RequestMethod.PUT)
	public Professor updatePassword(@RequestBody Professor professor, @PathVariable(name="password") String password) {
		return professorService.updatePassword(professor, password);
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.DELETE)
	public Professor delete(@RequestBody Professor professor) {
		return professorService.delete(professor);
	}
	@RequestMapping(value = "/updateProfessor",method=RequestMethod.DELETE)
	public Professor update(@RequestBody Professor professor) {
		return professorService.update(professor);
	}
	
	
}
