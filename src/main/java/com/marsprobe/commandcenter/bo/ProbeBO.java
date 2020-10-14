package com.marsprobe.commandcenter.bo;

import java.util.List;

import com.marsprobe.commandcenter.dao.ProbeDAO;
import com.marsprobe.commandcenter.entities.Probe;
import com.marsprobe.commandcenter.exceptions.DuplicateIdException;
import com.marsprobe.commandcenter.exceptions.ExistingProbeInPositionException;
import com.marsprobe.commandcenter.exceptions.InvalidRequestBodyException;
import com.marsprobe.commandcenter.exceptions.OutOfFieldBoundsException;
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
			
			if (probe.getX() > probe.getField().getLimitX() || probe.getY() > probe.getField().getLimitY()) {
				throw new OutOfFieldBoundsException("This probe is outside the field boundaries. Please change the coordinates. Field Limit X = " + probe.getField().getLimitX() + " Limit Y = " + probe.getField().getLimitY());
			}
			
			if (probe.getField() == null || probe.getField().getId() < 1) {
				throw new UnavailableFieldException("This field is not registered! Please input a valid Field ID");
			}
			
			for (Probe p : probe.getField().getProbes()) {
				if (p.getX() == probe.getX() && p.getY() == probe.getY() && p.getId() != probe.getId()) {
					throw new ExistingProbeInPositionException("There is a probe registered in this current position, try another one. Coordinate X: " + probe.getX() + " - Coordinate Y: " + probe.getY());
				}
			}
			dao.create(probe);
		} catch (DuplicateIdException e) {
			e.printStackTrace();
		} catch (UnavailableFieldException e) {
			e.printStackTrace();
		} catch (ExistingProbeInPositionException e) {
			e.printStackTrace();
		} catch (OutOfFieldBoundsException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(int id, Probe probe) { 
		
		try {
			Probe element = getProbeById(id);
			if(element.getId() != probe.getId()) {
				throw new InvalidRequestBodyException("Invalid RequestBody ID, try another one.");
			}
			
			if (probe.getX() > probe.getField().getLimitX() || probe.getY() > probe.getField().getLimitY()) {
				throw new OutOfFieldBoundsException("This probe is outside the field boundaries. Please change the coordinates. Field Limit X = " + probe.getField().getLimitX() + " Limit Y = " + probe.getField().getLimitY());
			}
			
			for (Probe p : probe.getField().getProbes()) {
				if (p.getX() == probe.getX() && p.getY() == probe.getY() && p.getId() != probe.getId()) {
					throw new ExistingProbeInPositionException("There is a probe registered in this current position, try another one. Coordinate X: " + probe.getX() + " - Coordinate Y: " + probe.getY());
				}
			}

			dao.update(id, probe);
		} catch (InvalidRequestBodyException e) {
			e.printStackTrace();
		} catch (ExistingProbeInPositionException e) {
			e.printStackTrace();
		} catch (OutOfFieldBoundsException e) {
			e.printStackTrace();
		}
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
