package com.marsprobe.commandcenter.service;

import java.util.ArrayList;
import java.util.List;

import com.marsprobe.commandcenter.bo.FieldBO;
import com.marsprobe.commandcenter.bo.ProbeBO;
import com.marsprobe.commandcenter.bo.ProbeCommandBO;
import com.marsprobe.commandcenter.dto.FieldDTO;
import com.marsprobe.commandcenter.dto.ProbeDTO;
import com.marsprobe.commandcenter.entities.DirectionEnum;
import com.marsprobe.commandcenter.entities.Field;
import com.marsprobe.commandcenter.entities.Probe;
import com.marsprobe.commandcenter.utils.FieldConverter;
import com.marsprobe.commandcenter.utils.ProbeConverter;

public class CommandCenterService {

	private FieldBO fieldBO = new FieldBO();
	private ProbeBO probeBO = new ProbeBO();
	private ProbeCommandBO probeCommandBO = new ProbeCommandBO();
	private FieldConverter fieldConveter = new FieldConverter();
	private ProbeConverter probeConverter = new ProbeConverter();

	public CommandCenterService() {
		super();
	}

	/*
	 * FIELDS
	 */
	public FieldDTO createField(FieldDTO fieldInput) {
		Field field = fieldConveter.convertFieldDTOToField(fieldInput);
		field.setProbes(new ArrayList<Probe>());
		fieldBO.create(field);
		return fieldInput; 
	}

	public FieldDTO updateField(int id, FieldDTO fieldInput) { 
		Field field = fieldConveter.convertFieldDTOToField(fieldInput);
		fieldBO.update(id, field);
		return fieldInput;
	}

	public void deleteField(int id) {
		fieldBO.delete(id);
	}

	public List<FieldDTO> getFieldsDTO() {
		List<Field> fields = fieldBO.getFields();
		List<FieldDTO> fieldsDTO = fieldConveter.convertFieldsToFieldsDTO(fields);
		return fieldsDTO;
	}

	public Field getFieldById(int id) { 
		return fieldBO.getFieldById(id); 
	}

	public FieldDTO getFieldDTOById(int id) { 
		Field element = getFieldById(id);
		FieldDTO dto = new FieldDTO();
		if (element != null) {
			dto = fieldConveter.convertFieldToFieldDTO(element);
		}
		return dto;
	}

	/*
	 * PROBES
	 */
	public ProbeDTO createProbe(ProbeDTO probeInput) {
		Field field = fieldBO.getFieldById(probeInput.getField());
		Probe probe = probeConverter.convertProbeDTOToProbe(probeInput, field);
		field.getProbes().add(probe);
		fieldBO.update(field.getId(), field);
		probeBO.create(probe);
		return probeInput; 
	}

	public void updateProbe(int id, ProbeDTO probeInput) { 
		Field field = fieldBO.getFieldById(probeInput.getField());
		Probe oldProbe = getProbeById(probeInput.getId());
		Probe probeUpdate = probeConverter.convertProbeDTOToProbe(probeInput, field);
		int index = field.getProbes().indexOf(oldProbe);
		field.getProbes().set(index, probeUpdate);
		fieldBO.update(field.getId(), field);
		probeBO.update(id, probeUpdate);
	}

	public void deleteProbe(int id) {
		probeBO.delete(id);
	}

	public List<ProbeDTO> getProbesDTO() {
		List<Probe> probes = probeBO.getProbes();
		List<ProbeDTO> probesDTO = probeConverter.convertProbesToProbesDTO(probes);
		return probesDTO;
	}

	public Probe getProbeById(int id) { 
		return probeBO.getProbeById(id); 
	}

	public ProbeDTO getProbeDTOById(int id) { 
		Probe element = getProbeById(id);
		ProbeDTO dto = new ProbeDTO();
		if (element != null) {
			dto = probeConverter.convertProbeToProbeDTO(element);
		}
		return dto; 
	}
	
	public ProbeDTO commandProbe(String command, ProbeDTO probeInput) {
		ProbeDTO dto = probeInput;
		if (probeCommandBO.validateCommand(command)) {
			for (char character : command.toLowerCase().toCharArray()) {
				int positionValue = dto.getDirection().getId();
				if (character == 'l') {
					if (positionValue == 1) {
						positionValue = 4;
					} else {
						positionValue--;
					}
					dto.setDirection(DirectionEnum.getById(positionValue));
				}
				if (character == 'r') {
					if (positionValue == 4) {
						positionValue = 1;
					} else {
						positionValue++;
					}
					dto.setDirection(DirectionEnum.getById(positionValue));
				}
				if (character == 'm') {
					if (dto.getDirection() == DirectionEnum.NORTH) {
						dto.setY(dto.getY() + 1);
					}
					if (dto.getDirection() == DirectionEnum.SOUTH) {
						dto.setY(dto.getY() - 1);
					}
					if (dto.getDirection() == DirectionEnum.EAST) {
						dto.setX(dto.getX() + 1);
					}
					if (dto.getDirection() == DirectionEnum.WEST) {
						dto.setX(dto.getX() - 1);
					}
				}
			}
		}
		updateProbe(dto.getId(), probeInput);
		return dto;
	}
	
	
}
