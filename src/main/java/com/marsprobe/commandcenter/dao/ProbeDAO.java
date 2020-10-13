package com.marsprobe.commandcenter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.marsprobe.commandcenter.entities.Probe;

public class ProbeDAO {
	
	private List<Probe> probes = new ArrayList<Probe>();

	public ProbeDAO() {
		super();
	}

	public void setProbes(List<Probe> probes) {
		this.probes = probes;
	}

	public void create(Probe probe) { probes.add(probe); }
	
	public void update(int id, Probe input) { 
		Probe probe = getProbeById(id);
		int index = this.probes.indexOf(probe);
		probes.set(index, input);
	}
	
	public void delete(int id) {
		Probe probe = getProbeById(id);
		int index = this.probes.indexOf(probe);
		probes.remove(index);
	}
	
	public List<Probe> getProbes() {
		return probes;
	}
	
	public Probe getProbeById(int id) { 
		Optional<Probe> element = this.probes.stream().filter(probe -> probe.getId() == id).findAny();
		Probe probe = null;
		if (element.isPresent()) {
			probe = element.get();		
		}
		return probe;
	}
	
	public Probe getProbeByPosition(int x, int y) { 
		Optional<Probe> element = this.probes.stream().filter(probe -> probe.getX() == x && probe.getY() == y).findAny();
		Probe probe = null;
		if (element.isPresent()) {
			probe = element.get();		
		}
		return probe;
	}
	
}
