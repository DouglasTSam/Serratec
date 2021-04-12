package org.serratec.finalproject.exceptions;

public class NotAllowedException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public NotAllowedException(Integer id) {
		super("It is not allowed to delete the resource with the ID " + id + " as it is linked to another list");
	}
}
