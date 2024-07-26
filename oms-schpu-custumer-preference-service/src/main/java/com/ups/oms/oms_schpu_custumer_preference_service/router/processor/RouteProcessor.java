/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.router.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.ups.oms.oms_schpu_custumer_preference_service.dto.RegistrationRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  25-Jul-2024 2024 11:47:50 pm
 */
@Component
@Slf4j
public class RouteProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		RegistrationRequest registrationRequest = exchange.getIn().getBody(RegistrationRequest.class);
		log.info("Registration Request {}",registrationRequest);
		
		
		
	}

	
}
