package com.marsprobe.commandcenter.service;

import java.util.ArrayList;
import java.util.List;

import com.marsprobe.commandcenter.bo.FieldBO;
import com.marsprobe.commandcenter.dto.FieldDTO;
import com.marsprobe.commandcenter.entities.Field;

public class FieldService {
	
	private FieldBO bo = new FieldBO();
	
	public FieldService() {
		super();
	}

	public FieldDTO create(FieldDTO fieldInput) {
		
		Field field = new Field();
		field.setId(fieldInput.getId());
		field.setLimitX(fieldInput.getLimitX());
		field.setLimitY(fieldInput.getLimitY());
		bo.create(field);
		return fieldInput; 

	}

	public FieldDTO update(int id, FieldDTO fieldInput) { 

		Field field = new Field();
		field.setId(fieldInput.getId());
		field.setLimitX(fieldInput.getLimitX());
		field.setLimitY(fieldInput.getLimitY());
		bo.update(id, field);
		
		return fieldInput;
	}

	public void delete(int id) {
		bo.delete(id);
	}

	public List<FieldDTO> getFieldsDTO() {
		List<Field> fields = bo.getFields();
		List<FieldDTO> fieldsDTO = new ArrayList<FieldDTO>();
		for (Field field : fields) {
			FieldDTO dto = new FieldDTO();
			dto.setId(field.getId());
			dto.setLimitX(field.getLimitX());
			dto.setLimitY(field.getLimitY());
			fieldsDTO.add(dto);
		}
		return fieldsDTO;
	}

	public Field getFieldById(int id) { 
		return bo.getFieldById(id); 
	}

	public FieldDTO getFieldDTOById(int id) { 
		
		Field element = getFieldById(id);
		FieldDTO dto = new FieldDTO();
		if (element != null) {
			dto.setId(element.getId());
			dto.setLimitX(element.getLimitX());
			dto.setLimitY(element.getLimitY());
		}
		return dto;
	}
}
