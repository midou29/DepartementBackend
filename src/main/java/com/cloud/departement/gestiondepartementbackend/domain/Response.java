package com.cloud.departement.gestiondepartementbackend.domain;

import java.io.Serializable;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7966419832196024102L;
	private String message;
	public String getMessage() {
		
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Response(String message) {
		super();
		this.message = message;
	}
	
	

}
