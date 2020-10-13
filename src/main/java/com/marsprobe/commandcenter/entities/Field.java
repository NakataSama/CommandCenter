package com.marsprobe.commandcenter.entities;

import java.util.List;

public class Field {

	private int id;
	private int limitX;
	private int limitY;
	private List<Probe> probes;
	
	public Field(int id, int limitX, int limitY, List<Probe> probes) {
		super();
		this.id = id;
		this.limitX = limitX;
		this.limitY = limitY;
		this.probes = probes;
	}

	public Field() {
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

	public List<Probe> getProbes() {
		return probes;
	}

	public void setProbes(List<Probe> probes) {
		this.probes = probes;
	}

	@Override
	public String toString() {
		return "Field [id=" + id + ", limitX=" + limitX + ", limitY=" + limitY + ", probes=" + probes + "]";
	}

}
