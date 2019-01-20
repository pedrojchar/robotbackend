package com.idealo.backend.robotbackend.logic;

import org.apache.commons.lang.ArrayUtils;

import com.idealo.backend.robotbackend.dto.RobotPositionDTO;

public class Utilities {
	
	private final String[] cardinalPoints = {"NORTH", "EAST", "SOUTH", "WEST"};
	
	public RobotPositionDTO moveRobot(String script) {
		RobotPositionDTO response = new RobotPositionDTO(0,0,"SOUTH");
		try {
			script = script.replace("\"", "");
			String[] lines = script.split("\\\\n");
			for(String line : lines) {
				response = determineInstruction(response, line.split("//")[0]);
			}
		} catch (Exception e) {
			response = new RobotPositionDTO(0,0,"down");
		}
		return response;
	}
	
	private RobotPositionDTO determineInstruction(RobotPositionDTO robotPosition, String line) {
		String[] parameters = line.split(" ");
		switch (parameters[0]) {
		case "POSITION":
			return new RobotPositionDTO(
					Integer.parseInt(parameters[1]),
					Integer.parseInt(parameters[2]),
					parameters[3]
					);
		case "FORWARD":
			determineMovement(robotPosition, Integer.parseInt(parameters[1]));
			break;
		case "WAIT":
			return robotPosition;
		case "TURNAROUND":
			return new RobotPositionDTO(
					robotPosition.getX(),
					robotPosition.getY(),
					determineDirection(robotPosition.getDir(), 2)
					);
		case "RIGHT":
			return new RobotPositionDTO(
					robotPosition.getX(),
					robotPosition.getY(),
					determineDirection(robotPosition.getDir(), 1)
					);
		case "LEFT":
			return new RobotPositionDTO(
					robotPosition.getX(),
					robotPosition.getY(),
					determineDirection(robotPosition.getDir(), -1)
					);
		default:
			break;
		}
		return robotPosition;
	}
	
	private String determineDirection(String direction, int move) {
		int indexDir = ArrayUtils.indexOf(cardinalPoints, direction);
		int index = indexDir + move;
		if(index > 3) {
			index = index - 4;
		} else if(index < 0) {
			index = index + 4;
		}
		return cardinalPoints[index];
	}
	
	private RobotPositionDTO determineMovement(RobotPositionDTO robotPosition, int move) {
		switch (robotPosition.getDir()) {
		case "NORTH":
			robotPosition.setY(robotPosition.getY()-move);;
			break;
		case "SOUTH":
			robotPosition.setY(robotPosition.getY()+move);;
			break;
		case "EAST":
			robotPosition.setX(robotPosition.getX()+move);;
			break;
		case "WEST":
			robotPosition.setX(robotPosition.getX()-move);;
			break;
		default:
			break;
		}
		return robotPosition;
	}
}
