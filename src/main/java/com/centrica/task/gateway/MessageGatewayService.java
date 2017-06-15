/**
 * 
 */
package com.centrica.task.gateway;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.centrica.task.api.model.Promotion;
import com.centrica.task.gateway.model.CustomerMessage;
import com.centrica.task.gateway.model.PromotionMessage;

/**
 * @author wemccl
 *
 */
@Service
public class MessageGatewayService extends MessageService implements MessageGateway {

    private static final Logger log = LoggerFactory.getLogger(MessageGatewayService.class);

    //private final RabbitTemplate rabbitTemplate;
	
	@Value("${remote.server.uri}")
	private String remoteUri;
	
	@Autowired
	RestTemplate promotionRestServiceTemplate ;
	
	
    @RabbitListener(queues = MessageService.CUSTOMER_QUEUE)
    public void receiveMessage(final CustomerMessage message) {
        log.info("Promotion listener received request message as spec: {}", message.toString());
        String targetUri = remoteUri + "/" + message.getCustomerId();
        // Call the service..
        Promotion promotion = promotionRestServiceTemplate.getForObject(targetUri, Promotion.class) ;
        PromotionMessage promotionMsg = new PromotionMessage(promotion.getMessage(), message.getPriority(), message.isSecret()) ;
        dispatchPromotion(MessageService.EXCHANGE_NAME, MessageService.PROMOTION_ROUTING_KEY, promotionMsg);
    }
    
    /**
     * 
     * @param exchangeName
     * @param routingKey
     * @param promotionMsg
     */
    public void dispatchPromotion(String exchangeName, String routingKey, PromotionMessage promotionMsg) {
        log.info("Sending promotion message...");
        rabbitTemplate.convertAndSend(exchangeName, routingKey, promotionMsg);
   	
    }

}