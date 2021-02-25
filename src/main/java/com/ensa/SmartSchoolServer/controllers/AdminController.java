package com.ensa.SmartSchoolServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.SmartSchoolServer.entity.Admin;
import com.ensa.SmartSchoolServer.service.AdminService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(value="/admin",method= {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/create",method=RequestMethod.POST)
	@ResponseBody
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminService.create(admin);
	}
	
	@RequestMapping(value = "/updateUsername/username={username}",method=RequestMethod.PUT)
	public Admin updateUsername(@RequestBody Admin admin,@PathVariable(name="username") String username) {
		return adminService.updateUsername(admin,username);
	}
	
	@RequestMapping(value = "/updatePassword",method=RequestMethod.PUT)
	public boolean updatePassword(@RequestBody Admin admin, @RequestParam(name="password") String password) {
		return adminService.updatePassword(admin,password);
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	public Admin delete(@RequestBody Admin admin) {
		return adminService.delete(admin);
	}
	
	@RequestMapping(value = "/getAdmins",method=RequestMethod.GET)
	public List<Admin> getAdmins() {
		return adminService.getAdmins();
	}
	
	@RequestMapping(value = "/getAdmin/username={username}",method=RequestMethod.POST)
	@ResponseBody
	public Admin getAdmin(@PathVariable(name="username") String username) {
		return adminService.getAdmin(username);
	}
	
	@RequestMapping(value = "/updateAdmin",method=RequestMethod.PUT)
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}
	
	
	

}
