package com.idealo.backend.robotbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idealo.backend.robotbackend.logic.Utilities;

@RestController
public class ControlService {

	@CrossOrigin
	@PostMapping(value = {"/robotbackend", "/robotBackend"}, produces="application/json")
	public Object robotBackend(@RequestBody String script) {
		Utilities util = new Utilities();
		return util.moveRobot(script);
	}
}
