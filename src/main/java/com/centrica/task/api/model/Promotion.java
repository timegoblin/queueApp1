/**
 * 
 */
package com.centrica.task.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author wemccl
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Promotion {

	public Promotion() {
		
	}
	
    private String message;

    public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Promotion( String msg) {
		this.message = msg ;
	}
}
