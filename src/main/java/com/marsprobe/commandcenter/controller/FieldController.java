package com.marsprobe.commandcenter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marsprobe.commandcenter.dto.FieldDTO;
import com.marsprobe.commandcenter.service.FieldService;

@RestController
public class FieldController {

	private FieldService service = new FieldService();
	
		@RequestMapping(value = "/fields", method = RequestMethod.GET)
	    public ResponseEntity<List<FieldDTO>> getAll() {
			
			if (service.getFieldsDTO().isEmpty()) {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<List<FieldDTO>>(service.getFieldsDTO(), HttpStatus.OK);
			}
	        
	    }

	    @RequestMapping(value = "/field/{id}", method = RequestMethod.GET)
	    public ResponseEntity<FieldDTO> getById(@PathVariable(value = "id") int id)
	    {
	        FieldDTO field = service.getFieldDTOById(id);
	        if(field.getId() != 0)
	            return new ResponseEntity<FieldDTO>(field, HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/field", method =  RequestMethod.POST )
	    public ResponseEntity<FieldDTO> post(@RequestBody FieldDTO field)
	    {
	    	FieldDTO response = service.create(field);
	    	return new ResponseEntity<FieldDTO>(response, HttpStatus.OK);
	    }

	    @RequestMapping(value = "/field/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<FieldDTO> put(@PathVariable(value = "id") int id, @RequestBody FieldDTO newField)
	    {
	    	FieldDTO field = service.getFieldDTOById(id);
	        if(field.getId() != 0){
	            service.update(id, newField);
	            return new ResponseEntity<FieldDTO>(newField, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/field/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id)
	    {
	    	FieldDTO field = service.getFieldDTOById(id);
	        if(field.getId() != 0){
	            service.delete(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}