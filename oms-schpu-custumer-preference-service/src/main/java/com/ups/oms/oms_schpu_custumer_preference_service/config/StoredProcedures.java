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
   @since  27-Jul-2024 2024 6:34:38 pm
 */
@Component
@ConfigurationProperties(prefix = Constants.STORED)
@Data
public class StoredProcedures {
	
	private String insertRegistrationData;
	
	private String getRegistrationData;

}
