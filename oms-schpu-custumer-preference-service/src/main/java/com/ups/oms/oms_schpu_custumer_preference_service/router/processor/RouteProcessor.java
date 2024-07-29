/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.router.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ups.oms.oms_schpu_custumer_preference_service.dto.RegistrationRequest;
import com.ups.oms.oms_schpu_custumer_preference_service.repository.CustomerPreferenceRepository;
import com.ups.oms.oms_schpu_custumer_preference_service.util.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  25-Jul-2024 2024 11:47:50 pm
 */
@Component
@Slf4j
public class RouteProcessor implements Processor {
	
	@Autowired
	CustomerPreferenceRepository customerPreferenceRepository;

	@Override
	public void process(Exchange exchange) throws Exception {
		
		RegistrationRequest registrationRequest = exchange.getIn().getBody(RegistrationRequest.class);
		String applicationSystemNumber = exchange.getIn().getHeader("ApplicationSystemNumber",String.class);
		
		log.info("ApplicationSystemNumber {} Registration Request {}",applicationSystemNumber,registrationRequest);
		customerPreferenceRepository.insertRegistrationData(applicationSystemNumber,Constants.SUCCESS,registrationRequest);
		
		
		
	}

	
}
