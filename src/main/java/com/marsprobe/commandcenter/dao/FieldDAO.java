package com.marsprobe.commandcenter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.marsprobe.commandcenter.entities.Field;

public class FieldDAO {
	
	private List<Field> fields = new ArrayList<Field>();

	public FieldDAO() {
		super();
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public void create(Field field) { this.fields.add(field); }
	
	public void update(int id, Field input) { 
		Field field = getFieldById(id);
		int index = this.fields.indexOf(field);
		this.fields.set(index, input);	
	}
	
	public void delete(int id) {
		Field field = getFieldById(id);
		int index = this.fields.indexOf(field);
		this.fields.remove(index);
	}
	
	public List<Field> getFields() {
		return fields;
	}
	
	public Field getFieldById(int id) { 
		Optional<Field> element = this.fields.stream().filter(field -> field.getId() == id).findAny();
		Field field = null;
		if (element.isPresent()) {
			field = element.get();		
		}
		return field;
	}
}
