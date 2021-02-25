package com.ensa.SmartSchoolServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchoolServer.dao.ModuleDao;
import com.ensa.SmartSchoolServer.entity.Module;

@Component
public class ModuleService {

	private ModuleDao moduleDao;

	@Autowired
	public ModuleService(ModuleDao moduleDao) {
		super();
		this.moduleDao = moduleDao;
	}
	public List<Module> getModules() {

		return this.moduleDao.getModules();
	}

	public Module getModule(String name) {
		return this.moduleDao.getModule(name);
	}

	public Module create(Module module) {

		return moduleDao.create(module);
	}

	public Module updateModuleName(Module module, String name) {
		return moduleDao.updateModuleName(module,name);
	}
	
	public Module delete(Module module) {
		return moduleDao.delete(module);
	}


}