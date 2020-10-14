package com.marsprobe.commandcenter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marsprobe.commandcenter.dto.FieldDTO;
import com.marsprobe.commandcenter.dto.ProbeDTO;
import com.marsprobe.commandcenter.service.CommandCenterService;

@RestController
public class CommandCenterController {

	private CommandCenterService service = new CommandCenterService();

	/*
	 * FIELDS
	 */
	@RequestMapping(value = "/fields", method = RequestMethod.GET)
	public ResponseEntity<List<FieldDTO>> getAllFields() {

		if (service.getFieldsDTO().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<FieldDTO>>(service.getFieldsDTO(), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/field/{id}", method = RequestMethod.GET)
	public ResponseEntity<FieldDTO> getFieldById(@PathVariable(value = "id") int id)
	{
		FieldDTO field = service.getFieldDTOById(id);
		if(field.getId() != 0)
			return new ResponseEntity<FieldDTO>(field, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/field", method =  RequestMethod.POST )
	public ResponseEntity<FieldDTO> postField(@RequestBody FieldDTO field)
	{
		FieldDTO response = service.createField(field);
		return new ResponseEntity<FieldDTO>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/field/{id}", method =  RequestMethod.PUT)
	public ResponseEntity<FieldDTO> putField(@PathVariable(value = "id") int id, @RequestBody FieldDTO newField)
	{
		FieldDTO field = service.getFieldDTOById(id);
		if(field.getId() != 0){
			service.updateField(id, newField);
			return new ResponseEntity<FieldDTO>(newField, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/field/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteField(@PathVariable(value = "id") int id)
	{
		FieldDTO field = service.getFieldDTOById(id);
		if(field.getId() != 0){
			service.deleteField(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/*
	 * PROBES
	 */
	@RequestMapping(value = "/probes", method = RequestMethod.GET)
	public ResponseEntity<List<ProbeDTO>> getAllProbes() {

		if (service.getProbesDTO().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<ProbeDTO>>(service.getProbesDTO(), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/probe/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProbeDTO> getProbeById(@PathVariable(value = "id") int id)
	{
		ProbeDTO probe = service.getProbeDTOById(id);
		if(probe.getId() != 0)
			return new ResponseEntity<ProbeDTO>(probe, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/probe", method =  RequestMethod.POST )
	public ResponseEntity<ProbeDTO> postProbe(@RequestBody ProbeDTO probe)
	{
		ProbeDTO response = service.createProbe(probe);
		return new ResponseEntity<ProbeDTO>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/probe/{id}", method =  RequestMethod.PUT)
	public ResponseEntity<ProbeDTO> putProbe(@PathVariable(value = "id") int id, @RequestBody ProbeDTO newProbe)
	{
		ProbeDTO probe = service.getProbeDTOById(id);
		if(probe.getId() != 0){
			service.updateProbe(id, newProbe);
			return new ResponseEntity<ProbeDTO>(newProbe, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/probe/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProbe(@PathVariable(value = "id") int id)
	{
		ProbeDTO probe = service.getProbeDTOById(id);
		if(probe.getId() != 0){
			service.deleteProbe(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/probe/{id}", params = "command", method =  RequestMethod.PUT)
	public ResponseEntity<ProbeDTO> commandProbe(@PathVariable(value = "id") int id, @RequestParam String command)
	{
		ProbeDTO probe = service.getProbeDTOById(id);
		if(probe.getId() != 0){
			probe = service.commandProbe(command, probe);
			return new ResponseEntity<ProbeDTO>(probe, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}