/**
 * 
 */
package com.centrica.task.service;

import com.centrica.task.api.model.Promotion;

/**
 * @author wemccl
 *
 */
public interface PromotionService {

	public Promotion getPromotionByCustomerId(String customerId) ;

}
