package com.idealo.backend.robotbackend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.backend.robotbackend.controller.ControlService;

import static org.junit.Assert.assertEquals;

import java.io.IOException;


@RunWith(SpringRunner.class)
@WebMvcTest(ControlService.class)
public class RobotbackendApplicationTests {
	
	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
	   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	   
	@Test
	public void scriptTest() throws Exception {
		String uri = "/robotbackend";
		String script = "POSITION 1 3 EAST //sets the initial position for the robot\\nFORWARD 3 //lets the robot do 3 steps forward\\nWAIT //lets the robot do nothing\\nTURNAROUND //lets the robot turn around\\nFORWARD 1 //lets the robot do 1 step forward\\nRIGHT //lets the robot turn right\\nFORWARD 2 //lets the robot do 2 steps forward\\n";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(script)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response, "{\"x\":3,\"y\":1,\"dir\":\"NORTH\"}");
	}
}

