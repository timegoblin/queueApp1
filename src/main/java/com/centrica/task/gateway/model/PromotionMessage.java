/**
 * 
 */
package com.centrica.task.gateway.model;

import java.io.Serializable;

/**
 * @author wemccl
 *
 */
public class PromotionMessage implements Serializable{

		private static final long serialVersionUID = 6195036629147010333L;
		private String text;
	    private int priority;
	    private boolean secret;

	    // Default constructor is needed to deserialize JSON
	    public PromotionMessage() {
	    }

	    public PromotionMessage(String text, int priority, boolean secret) {
	        this.text = text;
	        this.priority = priority;
	        this.secret = secret;
	    }

	    public String getText() {
	        return text;
	    }

	    public int getPriority() {
	        return priority;
	    }

	    public boolean isSecret() {
	        return secret;
	    }

	    @Override
	    public String toString() {
	        return "CustomMessage{" +
	                "text='" + text + '\'' +
	                ", priority=" + priority +
	                ", secret=" + secret +
	                '}';
	    }
}
