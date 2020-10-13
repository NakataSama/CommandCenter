//package com.marsprobe.commandcenter.bo;
//
//import java.util.List;
//
//import com.marsprobe.commandcenter.dao.ProbeDAO;
//import com.marsprobe.commandcenter.dto.ProbeCommandDTO;
//import com.marsprobe.commandcenter.entities.Probe;
//import com.marsprobe.commandcenter.exceptions.DuplicateIdException;
//import com.marsprobe.commandcenter.exceptions.InvalidRequestBodyException;
//import com.marsprobe.commandcenter.exceptions.RecordsNotFoundException;
//import com.marsprobe.commandcenter.exceptions.UnavailableFieldException;
//
//public class ProbeCommandBO {
//
//	public ProbeCommandBO() {
//		super();
//	}
//
//	public void read(ProbeCommandDTO command) { 
//		
//		try {
//			
//			Probe element = getProbeById(probe.getId());
//			if (element != null) {
//				throw new DuplicateIdException("This probe ID is already in use! Try another one. ID: " + probe.getId());
//			}
//			
//			if (probe.getField() == null) {
//				throw new UnavailableFieldException("This field is not registered! Please input a valid Field ID");
//			}
//			
//		} catch (DuplicateIdException e) {
//			e.printStackTrace();
//		} catch (UnavailableFieldException e) {
//			e.printStackTrace();
//		}
//		
//		dao.create(probe);
//	}
//	
//}
