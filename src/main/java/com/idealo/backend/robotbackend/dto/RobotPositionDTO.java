package com.idealo.backend.robotbackend.dto;

public class RobotPositionDTO {
	Integer x;
	Integer y;
	String dir;
	
	public RobotPositionDTO() {}
	
	public RobotPositionDTO(Integer x, Integer y, String dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
}
