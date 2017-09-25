/**
 * @author bvans
 * @since 9/21/2017
 */

package com.apress.isf.spring.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DocumentScheduler {
	private static Logger log = LoggerFactory.getLogger(DocumentScheduler.class);
	
	@Scheduled(fixedRate=3000)
	public void sampleCronMethod(){
		log.debug("Running every 3 seconds ...");
	}
	

}
