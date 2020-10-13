package com.marsprobe.commandcenter.dto;

import com.marsprobe.commandcenter.entities.DirectionEnum;

public class ProbeDTO {

	private int id;
	private String name;
	private int x;
	private int y;
	private DirectionEnum direction;
	private int field;
	
	public ProbeDTO(int id, String name, int x, int y, DirectionEnum direction, int field) {
		super();
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.field = field;
	}
	
	public ProbeDTO() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public DirectionEnum getDirection() {
		return direction;
	}
	
	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}
	
	public int getField() {
		return field;
	}
	
	public void setField(int field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "Probe [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", direction=" + direction.getDescription() + ", field="
				+ field + "]";
	}

}
