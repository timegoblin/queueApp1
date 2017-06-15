/**
 * 
 */
package com.centrica.task.gateway.model;

import java.io.Serializable;

/**
 * @author wemccl
 *
 */
public class CustomerMessage implements Serializable{

	private static final long serialVersionUID = 6195036629147010333L;
	private String customerId;
    private int priority;
    private boolean secret;

    // Default constructor is needed to deserialize JSON
    public CustomerMessage() {
    }

    public CustomerMessage(String id, int priority, boolean secret) {
        this.customerId = id;
        this.priority = priority;
        this.secret = secret;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "CustomerMessage{" +
                "customerId='" + customerId + '\'' +
                ", priority=" + priority +
                ", secret=" + secret +
                '}';
    }
}
