package com.marsprobe.commandcenter.entities;

public class Probe {

	private int id;
	private String name;
	private int x;
	private int y;
	private DirectionEnum direction;
	private Field field;
	
	public Probe(int id, String name, int x, int y, DirectionEnum direction, Field field) {
		super();
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.field = field;
	}
	
	public Probe() {
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
	
	public Field getField() {
		return field;
	}
	
	public void setField(Field field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "Probe [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", direction=" + direction.getDescription() + ", field="
				+ field + "]";
	}

}
