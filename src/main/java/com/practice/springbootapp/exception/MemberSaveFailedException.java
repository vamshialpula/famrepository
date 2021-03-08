package com.practice.springbootapp.exception;

public class MemberSaveFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberSaveFailedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MemberSaveFailedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
