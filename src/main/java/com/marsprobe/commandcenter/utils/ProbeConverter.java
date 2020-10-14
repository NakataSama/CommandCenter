package com.marsprobe.commandcenter.utils;

import java.util.ArrayList;
import java.util.List;

import com.marsprobe.commandcenter.dto.ProbeDTO;
import com.marsprobe.commandcenter.entities.Field;
import com.marsprobe.commandcenter.entities.Probe;

public class ProbeConverter {
		
	public ProbeConverter() {
		super();
	}

	public Probe convertProbeDTOToProbe(ProbeDTO probeInput, Field field) {
		Probe probe = new Probe();
		probe.setId(probeInput.getId());
		probe.setName(probeInput.getName());
		probe.setX(probeInput.getX());
		probe.setY(probeInput.getY());
		probe.setDirection(probeInput.getDirection());
		probe.setField(field);
		return probe; 
	}
	
	public ProbeDTO convertProbeToProbeDTO(Probe probeInput) {
		ProbeDTO dto = new ProbeDTO();
		dto.setId(probeInput.getId());
		dto.setName(probeInput.getName());
		dto.setX(probeInput.getX());
		dto.setY(probeInput.getY());
		dto.setDirection(probeInput.getDirection());
		dto.setField(probeInput.getField().getId());
		return dto;
	}

	public List<ProbeDTO> convertProbesToProbesDTO(List<Probe> probesInput) {
		List<ProbeDTO> probesDTO = new ArrayList<ProbeDTO>();
		for (Probe probe : probesInput) {
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
	
}
