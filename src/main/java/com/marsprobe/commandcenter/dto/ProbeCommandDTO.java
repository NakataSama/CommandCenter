package com.marsprobe.commandcenter.dto;

public class ProbeCommandDTO {

	private Integer fieldId;
	private Integer probeId;
	private String movementCommand;
	
	public ProbeCommandDTO(Integer fieldId, Integer probeId, String movementCommand) {
		super();
		this.fieldId = fieldId;
		this.probeId = probeId;
		this.movementCommand = movementCommand;
	}

	public ProbeCommandDTO() {
		super();
	}

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public Integer getProbeId() {
		return probeId;
	}

	public void setProbeId(Integer probeId) {
		this.probeId = probeId;
	}
	
	public String getMovementCommand() {
		return movementCommand;
	}

	public void setMovementCommand(String movementCommand) {
		this.movementCommand = movementCommand;
	}

	@Override
	public String toString() {
		return "ProbeCommandDTO [fieldId=" + fieldId + ", probeId=" + probeId + ", movementCommand=" + movementCommand + "]";
	}
	
}
