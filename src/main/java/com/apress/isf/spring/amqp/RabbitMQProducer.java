package com.apress.isf.spring.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.utils.XmlUtils;

/**
 * 
 * @author dirkseActive
 * @since 5/25/2017
 */

@Component("rabbitMQProducer")
public class RabbitMQProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send(Document document) {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setContentType("text/xml");
		byte[] body = XmlUtils.toXML(document).getBytes();
		Message message = new Message(body, messageProperties);
		rabbitTemplate.send(message);
	}
}
