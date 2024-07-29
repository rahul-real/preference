/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.router;

import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.lang3.StringUtils;
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
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				String applicationSystemNumber = exchange.getIn().getHeader("ApplicationSystemNumber",String.class);
				if (StringUtils.isBlank(applicationSystemNumber)) {
					applicationSystemNumber = UUID.randomUUID().toString();
					
				}
				exchange.getIn().setHeader("ApplicationSystemNumber", applicationSystemNumber);
				
			}
		})
		.unmarshal().json(JsonLibrary.Jackson,RegistrationRequest.class)
		.process(proccessor)
		.end();
		
		
		
	}
	
	

}
