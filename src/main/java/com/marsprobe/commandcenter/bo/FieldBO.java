package com.marsprobe.commandcenter.bo;

import java.util.List;

import com.marsprobe.commandcenter.dao.FieldDAO;
import com.marsprobe.commandcenter.entities.Field;
import com.marsprobe.commandcenter.exceptions.DuplicateIdException;
import com.marsprobe.commandcenter.exceptions.InvalidFieldSizeException;
import com.marsprobe.commandcenter.exceptions.InvalidIdException;
import com.marsprobe.commandcenter.exceptions.InvalidRequestBodyException;
import com.marsprobe.commandcenter.exceptions.RecordsNotFoundException;

public class FieldBO {
	
	private FieldDAO dao = new FieldDAO();

	public FieldBO() {
		super();
	}

	public void create(Field field) { 
		
		try {
			
			Field element = getFieldById(field.getId());
			if (element != null) {
				throw new DuplicateIdException("This field ID is already in use! Try another one. ID: " + field.getId());
			}
			
			if (field.getLimitX() < 5 || field.getLimitY() < 5) {
				throw new InvalidFieldSizeException("This field size is too small, the minimum value for X and Y should be at least 5.");
			}
			
			if (field.getId() < 1) {
				throw new InvalidIdException("This is not a valid value for the Identification Key, the minimum is 1");
			}
			
			dao.create(field);
			
		} catch (DuplicateIdException e) {
			e.printStackTrace();
		} catch (InvalidFieldSizeException e) {
			e.printStackTrace();
		} catch (InvalidIdException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void update(int id, Field field) { 
		
		try {
			Field element = getFieldById(id);
				
			if(element.getId() != field.getId()) {
				throw new InvalidRequestBodyException("Invalid RequestBody ID, try another one.");
			}
				
			if (field.getLimitX() < 5 || field.getLimitY() < 5) {
				throw new InvalidFieldSizeException("This field size is too small, the minimum value for it to be created is 5.");
			}

			if (element.getId() < 1) {
				throw new InvalidIdException("This is not a valid value for the Identification Key, the minimum is 1");
			}
			
			dao.update(id, field);
			
		} catch (InvalidRequestBodyException e) {
			e.printStackTrace();
		} catch (InvalidFieldSizeException e) {
			e.printStackTrace();
		} catch (InvalidIdException e) {
			e.printStackTrace();
		}
	
	}
	
	public void delete(int id) {
		dao.delete(id);
	}
	
	public List<Field> getFields() {
		List<Field> fields = null;
		try {
			fields = dao.getFields();
			if (fields.size() < 1) {
				throw new RecordsNotFoundException("There are no records available for this request.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return fields;
	}
	
	public Field getFieldById(int id) { 
		return dao.getFieldById(id); 
	}
	
}
