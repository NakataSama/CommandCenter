package com.marsprobe.commandcenter.service;

import java.util.ArrayList;
import java.util.List;

import com.marsprobe.commandcenter.bo.FieldBO;
import com.marsprobe.commandcenter.bo.ProbeBO;
import com.marsprobe.commandcenter.dto.ProbeDTO;
import com.marsprobe.commandcenter.entities.Field;
import com.marsprobe.commandcenter.entities.Probe;

public class ProbeService {
	
	private ProbeBO probeBO = new ProbeBO();
	private FieldBO fieldBO;
		
	public ProbeService() {
		super();
	}

	public ProbeDTO create(ProbeDTO probeInput) {
		
		Field field = fieldBO.getFieldById(probeInput.getField());
		System.out.println(field.toString());
		Probe probe = new Probe();
		probe.setId(probeInput.getId());
		probe.setName(probeInput.getName());
		probe.setX(probeInput.getX());
		probe.setY(probeInput.getY());
		probe.setDirection(probeInput.getDirection());
		probe.setField(field);
		field.getProbes().add(probe);
		fieldBO.update(field.getId(), field);
		probeBO.create(probe);
		return probeInput; 

	}

	public void update(int id, ProbeDTO probeInput) { 

		Field field = fieldBO.getFieldById(probeInput.getField());
		Probe probe = new Probe();
		probe.setId(probeInput.getId());
		probe.setName(probeInput.getName());
		probe.setX(probeInput.getX());
		probe.setY(probeInput.getY());
		probe.setDirection(probeInput.getDirection());
		probe.setField(field);
		field.getProbes().add(probe);
		fieldBO.update(field.getId(), field);
		probeBO.update(id, probe);
		
	}

	public void delete(int id) {
		probeBO.delete(id);
	}

	public List<ProbeDTO> getProbesDTO() {
		List<Probe> probes = probeBO.getProbes();
		List<ProbeDTO> probesDTO = new ArrayList<ProbeDTO>();
		for (Probe probe : probes) {
			ProbeDTO dto = new ProbeDTO();
			dto.setId(probe.getId());
			dto.setName(probe.getName());
			dto.setX(probe.getX());
			dto.setY(probe.getY());
			dto.setDirection(probe.getDirection());
			dto.setField(probe.getField().getId());
			probesDTO.add(dto);
		}
		return probesDTO;
	}

	public Probe getProbeById(int id) { 
		return probeBO.getProbeById(id); 
	}

	public ProbeDTO getProbeDTOById(int id) { 
		Probe probe = getProbeById(id);
		ProbeDTO dto = new ProbeDTO();
		dto.setId(probe.getId());
		dto.setName(probe.getName());
		dto.setX(probe.getX());
		dto.setY(probe.getY());
		dto.setDirection(probe.getDirection());
		dto.setField(probe.getField().getId());
		return dto; 
	}
}
