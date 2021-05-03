package com.salci.myfun.exception;

public class ResourceNotFoundexception extends RuntimeException{

	public ResourceNotFoundexception(String message) {
		
		super(message);
	}
	
	public ResourceNotFoundexception(String message,Throwable cause) {
		
		super(message,cause);
	}
}
