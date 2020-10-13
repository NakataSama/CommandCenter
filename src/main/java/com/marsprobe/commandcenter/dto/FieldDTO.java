package com.marsprobe.commandcenter.dto;

public class FieldDTO {

	private int id;
	private int limitX;
	private int limitY;
	
	public FieldDTO(int id, int limitX, int limitY) {
		super();
		this.id = id;
		this.limitX = limitX;
		this.limitY = limitY;
	}

	public FieldDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLimitX() {
		return limitX;
	}

	public void setLimitX(int limitX) {
		this.limitX = limitX;
	}

	public int getLimitY() {
		return limitY;
	}

	public void setLimitY(int limitY) {
		this.limitY = limitY;
	}
	
	@Override
	public String toString() {
		return "Field [id=" + id + ", limitX=" + limitX + ", limitY=" + limitY + "]";
	}

}
