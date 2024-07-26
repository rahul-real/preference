/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.ups.oms.oms_schpu_custumer_preference_service.util.Constants;

import lombok.Data;

/**
 * @author rahul
   @since  25-Jul-2024 2024 7:37:06 pm
 */
@Component
@ConfigurationProperties(prefix = Constants.QUEUE_PREFIX)
@Data
public class QueueConfig {
	
	private String brokerUrl;
	
	private String username;
	
	private String password;
	
	private String componentName;
	
	private int maxConnections;
	
	private int maxActive;
	

}
