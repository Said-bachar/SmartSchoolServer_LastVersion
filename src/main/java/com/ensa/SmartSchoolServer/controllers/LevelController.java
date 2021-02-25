package com.ensa.SmartSchoolServer.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ensa.SmartSchoolServer.entity.Level;
import com.ensa.SmartSchoolServer.entity.Module;
import com.ensa.SmartSchoolServer.entity.Professor;
import com.ensa.SmartSchoolServer.service.LevelService;

@RestController
@RequestMapping(value="/level",method= {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class LevelController {
	
	@Autowired
	private LevelService levelService;
	
	@RequestMapping(value = "/create",method=RequestMethod.POST)
	@ResponseBody
	public Level create(@RequestBody Level level) {
		return levelService.create(level);
	}
	
	@RequestMapping(value = "/update/levelname={levelname}",method=RequestMethod.PUT)
	public Level updateLevelName(@RequestBody Level level,@PathVariable(name="levelname") String levelname) {
		return levelService.updateLevelName(level, levelname);
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	public Level delete(@RequestBody Level level) {
		return levelService.delete(level);
	}
	
	@RequestMapping(value = "/getLevels",method=RequestMethod.GET)
	public List<Level> getLevels() {
		return levelService.getLevels();
	}
	
	@RequestMapping(value = "/getModules/levelname={levelname}",method=RequestMethod.POST)
	@ResponseBody
	public List<Module> getModules(@PathVariable(name="levelname") String levelName) {
		return levelService.getModules(levelName);
	}
	
    @RequestMapping(value = "/getProfessors/levelname={levelname}",method=RequestMethod.GET)
    @ResponseBody
	public List<Professor> getProfessors(@PathVariable(name="levelname") String levelName) {
		return levelService.getProfessors(levelName);
	}
    
    @RequestMapping(value = "/getLevel/levelname={levelname}",method=RequestMethod.POST)
	@ResponseBody
	public Level getLevel(@PathVariable(name="levelname") String levelname) {
		return levelService.getLevel(levelname);
	}
	
}
