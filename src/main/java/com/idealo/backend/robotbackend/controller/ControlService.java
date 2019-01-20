package com.idealo.backend.robotbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idealo.backend.robotbackend.dto.RobotPositionDTO;
import com.idealo.backend.robotbackend.logic.Utilities;

@RestController
public class ControlService {

	@CrossOrigin(origins = {"http://localhost:4200", "https://robotbackend.herokuapp.com/"})
	@PostMapping(value = {"/robotbackend", "/robotBackend"}, produces="application/json")
	public Object robotBackend(@RequestBody String script) {
		Utilities util = new Utilities();
		return util.moveRobot(script);
	}
}
