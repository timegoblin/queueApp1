/**
 * 
 */
package com.centrica.task.api.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.centrica.task.api.model.Promotion;
import com.centrica.task.service.PromotionService;

/**
 * @author wemccl
 *
 */
@RestController
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	PromotionService promotionService ;
	
	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Promotion> getCustomer (@PathVariable("customerId") String customerId) {
		return new ResponseEntity<Promotion>(promotionService.getPromotionByCustomerId(customerId), HttpStatus.OK) ;
	}

}
