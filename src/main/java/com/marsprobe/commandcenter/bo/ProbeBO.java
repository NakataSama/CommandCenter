package com.marsprobe.commandcenter.bo;

import java.util.List;

import com.marsprobe.commandcenter.dao.ProbeDAO;
import com.marsprobe.commandcenter.entities.Probe;
import com.marsprobe.commandcenter.exceptions.DuplicateIdException;
import com.marsprobe.commandcenter.exceptions.InvalidRequestBodyException;
import com.marsprobe.commandcenter.exceptions.RecordsNotFoundException;
import com.marsprobe.commandcenter.exceptions.UnavailableFieldException;

public class ProbeBO {
	
	private ProbeDAO dao = new ProbeDAO();

	public ProbeBO() {
		super();
	}

	public void create(Probe probe) { 
		
		try {
			
			Probe element = getProbeById(probe.getId());
			if (element != null) {
				throw new DuplicateIdException("This probe ID is already in use! Try another one. ID: " + probe.getId());
			}
			
			if (probe.getField() == null) {
				throw new UnavailableFieldException("This field is not registered! Please input a valid Field ID");
			}
			
		} catch (DuplicateIdException e) {
			e.printStackTrace();
		} catch (UnavailableFieldException e) {
			e.printStackTrace();
		}
		
		dao.create(probe);
	}
	
	public void update(int id, Probe probe) { 
		
		try {
			Probe element = getProbeById(id);
			if(element.getId() != probe.getId()) {
				throw new InvalidRequestBodyException("Invalid RequestBody ID, try another one.");
			}
			
		} catch (InvalidRequestBodyException e) {
			e.printStackTrace();
		}
		dao.update(id, probe);
	}
	
	public void delete(int id) {
		dao.delete(id);
	}
	
	public List<Probe> getProbes() {
		List<Probe> probes = null;
		try {
			probes = dao.getProbes();
			if (probes.size() < 1) {
				throw new RecordsNotFoundException("There are no records available for this request.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return probes;
	}
	
	public Probe getProbeById(int id) { 
		return dao.getProbeById(id); 
	}
	
	public Probe getProbeByPosition(int x, int y) { 
		return dao.getProbeByPosition(x, y); 		
	} 
	
}
