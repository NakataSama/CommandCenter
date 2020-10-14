package com.marsprobe.commandcenter.utils;

import java.util.ArrayList;
import java.util.List;

import com.marsprobe.commandcenter.dto.FieldDTO;
import com.marsprobe.commandcenter.entities.Field;

public class FieldConverter {
	
	public FieldConverter() {
		super();
	}

	public Field convertFieldDTOToField(FieldDTO fieldInput) {
		Field field = new Field();
		field.setId(fieldInput.getId());
		field.setLimitX(fieldInput.getLimitX());
		field.setLimitY(fieldInput.getLimitY());
		return field; 
	}
	
	public FieldDTO convertFieldToFieldDTO(Field fieldInput) {
		FieldDTO dto = new FieldDTO();
		dto.setId(fieldInput.getId());
		dto.setLimitX(fieldInput.getLimitX());
		dto.setLimitY(fieldInput.getLimitY());
		return dto;
	}
	
	public List<FieldDTO> convertFieldsToFieldsDTO(List<Field> fieldsInput) {
		List<FieldDTO> fieldsDTO = new ArrayList<FieldDTO>();
		for (Field field : fieldsInput) {
			FieldDTO dto = new FieldDTO();
			dto.setId(field.getId());
			dto.setLimitX(field.getLimitX());
			dto.setLimitY(field.getLimitY());
			fieldsDTO.add(dto);
		}
		return fieldsDTO;
	}
}
