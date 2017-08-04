package com.apress.isf.spring.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.amqp.RabbitMQProducer;
import com.apress.isf.spring.jms.JMSProducer;

/**
 * 
 * @author dirkseActive
 * @since 5/19/2017
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyDocumentsTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
	//Based on the META-INF/data/jms.txt - only one record
	private static final int MAX_ALL_DOCS = 5;
	private static final int MAX_WEB_DOCS = 2;
	private static final String DOCUMENT_ID = "df569fa4-a513-4252-9810-818cade184ca";
	
	@Autowired
	private SearchEngine engine;
	
	@Autowired
	JMSProducer jmsProducer;
	
	@Test
	public void testSpringJMS_1(){
		log.debug("Testing Spring JMS Producer...");
		jmsProducer.send();
	}
	
	@Test
	public void testSpringJMS_2() throws InterruptedException {
		log.debug("Testing Spring JMC Listener/Insert...");
		assertNotNull(engine);
		
		//Waiting at least 5 seconds so the message is consumed
		Thread.sleep(5000);
		//After the JMS message and insert, must be 5 Documents
		assertEquals(MAX_ALL_DOCS, engine.listAll().size());
		
		Type documentType = new Type("Web",".url");
		assertEquals(MAX_WEB_DOCS, engine.findByType(documentType).size());
	}
	
	@Autowired
	RabbitMQProducer rabbitmqProducer;
	
	@Test
	public void testSpringRabbitMQ_1() {
		log.debug("Testing RabbitMQ producer...");
		assertNotNull(rabbitmqProducer);
		
		Document document = engine.findById(DOCUMENT_ID);
		assertNotNull(document);
		rabbitmqProducer.send(document);
	}

}
