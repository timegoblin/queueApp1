/**
 * 
 */
package com.centrica.task.api;

import org.springframework.http.ResponseEntity;

import com.centrica.task.api.model.Promotion;

/**
 * @author wemccl
 *
 */
public interface PromotionApi {
	/**
	 * Promotion api method to return promotion
	 * 
	 * @return
	 */
	public ResponseEntity<Promotion> getPromotion(String customerId);

}
