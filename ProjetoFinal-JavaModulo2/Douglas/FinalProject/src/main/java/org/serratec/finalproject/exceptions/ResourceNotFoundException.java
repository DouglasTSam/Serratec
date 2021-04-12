package org.serratec.finalproject.exceptions;

public class ResourceNotFoundException extends Exception{

	private Integer id;
	
	public ResourceNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
