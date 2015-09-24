package pl.plask.team.yplanner.web.model.dto;

import java.io.Serializable;

public class GeneratedPassword implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1414157195021514727L;
	
	private String password;
	
	public GeneratedPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
