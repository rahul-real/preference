/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ups.oms.oms_schpu_custumer_preference_service.config.Queues;
import com.ups.oms.oms_schpu_custumer_preference_service.dto.RegistrationRequest;
import com.ups.oms.oms_schpu_custumer_preference_service.router.processor.RouteProcessor;

/**
 * @author rahul
   @since  25-Jul-2024 2024 7:28:08 pm
 */
@Component
public class Router extends RouteBuilder  {
	
	@Autowired
	Queues queues;
	
	@Autowired
	RouteProcessor proccessor;

	@Override
	public void configure() throws Exception {
		
		from(queues.getMyQueue())
		.log("${body}")
		.unmarshal().json(JsonLibrary.Jackson,RegistrationRequest.class)
		.process(proccessor)
		.end();
		
		
		
	}
	
	

}
