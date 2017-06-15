package com.centrica.task.service.customer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.centrica.task.api.model.Promotion;
import com.centrica.task.gateway.MessageGateway;
import com.centrica.task.service.PromotionService;

/**
 * 
 * @author wemccl
 *
 */
@Component
public class PromotionDataService implements PromotionService {

	private static final Logger log = LoggerFactory.getLogger(PromotionDataService.class);

	@Autowired
	MessageGateway messageGateway ;
	
	public Promotion getPromotionByCustomerId(String customerId) {
		// Really retrieve by customerId from repository
		Promotion promotion = new Promotion(customerId);
		promotion.setMessage("You qualify for 10% discount.  Enter code SWTQ887");
		return promotion ;
	}
	

}
