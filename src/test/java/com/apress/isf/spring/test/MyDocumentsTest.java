package com.apress.isf.spring.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;

/**
 * 
 * @author dirkseActive
 * @since 5/19/2017
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
	//Based on the META-INF/data/jms.txt - only one record
	private static final int MAX_ALL_DOCS = 5;
	private static final int MAX_WEB_DOCS = 2;
	
	@Autowired
	private SearchEngine engine;
	
	@Test
	public void testSpringJMS() throws InterruptedException {
		log.debug("Testing Spring JMC Listener/Insert...");
		assertNotNull(engine);
		
		//Waiting at least 5 seconds so the message is consumed
		Thread.sleep(5000);
		//After the JMS message and insert, must be 5 Documents
		assertEquals(MAX_ALL_DOCS, engine.listAll().size());
		
		Type documentType = new Type("Web",".ulr");
		assertEquals(MAX_WEB_DOCS, engine.findByType(documentType).size());
	}

}
