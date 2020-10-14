package com.marsprobe.commandcenter.bo;

import com.marsprobe.commandcenter.exceptions.InvalidCommandException;

public class ProbeCommandBO {

	public ProbeCommandBO() {
		super();
	}

	public boolean validateCommand(String command) { 
		boolean validation = false;
		String regex = "[^lrmLRM]+";
		try {
			if(command.matches(regex)) {
				throw new InvalidCommandException("This command is invalid. Commands should only use the L (Left), R (Right) and M (Move) characters.");
			} else {
				validation = true;
			}
		} catch (InvalidCommandException e) {
			e.printStackTrace();
		}
		
		return validation;
	}
	
}
