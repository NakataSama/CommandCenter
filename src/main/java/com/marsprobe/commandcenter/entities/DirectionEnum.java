package com.marsprobe.commandcenter.entities;

public enum DirectionEnum {
	
	NORTH(1, "North"), 
	EAST(2,"East"),
	SOUTH(3, "South"),
	WEST(4, "West");
	
	private int id;
	private String description;
	
	private DirectionEnum(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static DirectionEnum getById(int id) {
	    for(DirectionEnum eNum : values()) {
	        if(eNum.getId() == id) return eNum;
	    }
	    return null;
	}
}
