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
   @since  25-Jul-2024 2024 11:20:50 pm
 */
@Component
@ConfigurationProperties(prefix = Constants.QUEUE)
@Data
public class Queues {
	
	private String myQueue;

}
