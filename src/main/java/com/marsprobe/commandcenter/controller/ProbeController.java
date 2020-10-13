package com.marsprobe.commandcenter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marsprobe.commandcenter.dto.ProbeDTO;
import com.marsprobe.commandcenter.service.ProbeService;

@RestController
public class ProbeController {
	
	private ProbeService service = new ProbeService();
	
	@RequestMapping(value = "/probes", method = RequestMethod.GET)
    public ResponseEntity<List<ProbeDTO>> getAll() {
		
		if (service.getProbesDTO().isEmpty()) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<ProbeDTO>>(service.getProbesDTO(), HttpStatus.OK);
		}
        
    }

    @RequestMapping(value = "/probe/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProbeDTO> getById(@PathVariable(value = "id") int id)
    {
        ProbeDTO probe = service.getProbeDTOById(id);
        if(probe.getId() != 0)
            return new ResponseEntity<ProbeDTO>(probe, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/probe", method =  RequestMethod.POST )
    public ResponseEntity<ProbeDTO> post(@RequestBody ProbeDTO probe)
    {
    	ProbeDTO response = service.create(probe);
    	return new ResponseEntity<ProbeDTO>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/probe/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<ProbeDTO> put(@PathVariable(value = "id") int id, @RequestBody ProbeDTO newProbe)
    {
    	ProbeDTO probe = service.getProbeDTOById(id);
        if(probe.getId() != 0){
            service.update(id, newProbe);
            return new ResponseEntity<ProbeDTO>(newProbe, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/probe/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id)
    {
    	ProbeDTO probe = service.getProbeDTOById(id);
        if(probe.getId() != 0){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	    
}