/**
 * 
 */
package com.centrica.task.gateway;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wemccl
 *
 */
@Configuration
@EnableRabbit
public abstract class MessageService {

	public static final String EXCHANGE_NAME = "appExchange";
	public static final String CUSTOMER_QUEUE = "appCustomerQueue";
	public static final String PROMOTION_QUEUE = "appPromotionQueue";
	public static final String ROUTING_KEY = "messages.key";
	public static final String PROMOTION_ROUTING_KEY = "promotion.key";

	@Autowired
	protected RabbitTemplate rabbitTemplate;
	
	/**
    @Autowired
    private ConnectionFactory connectionFactory;
	**/
	
    @Bean
	public TopicExchange appExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}
    
	@Bean
	public Queue appCustomerQueue() {
		return new Queue(CUSTOMER_QUEUE);
	}

	@Bean
	public Queue appPromotionQueue() {
		return new Queue(PROMOTION_QUEUE);
	}

	@Bean
	public Binding declareBindingGeneric() {
		return BindingBuilder.bind(appCustomerQueue()).to(appExchange()).with(ROUTING_KEY);
	}

	@Bean
	public Binding declareBindingSpecific() {
		return BindingBuilder.bind(appPromotionQueue()).to(appExchange()).with(PROMOTION_ROUTING_KEY);
	}
	
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    
    //@Bean
    //AsyncRabbitTemplate template() {
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
    //    container.addQueueNames(PROMOTION_QUEUE);
    //    container.addQueueNames(CUSTOMER_QUEUE);
    //    container.setQueueNames(PROMOTION_QUEUE);
    //    return new AsyncRabbitTemplate(rabbitTemplate, container);
    //}

}
