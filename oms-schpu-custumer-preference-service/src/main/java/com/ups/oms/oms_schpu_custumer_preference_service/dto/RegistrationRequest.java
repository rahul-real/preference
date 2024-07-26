/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.dto;

import lombok.Data;

/**
 * @author rahul
   @since  25-Jul-2024 2024 11:58:34 pm
 */
@Data
public class RegistrationRequest {
	
	private String parId;
	
	private Byte registrationCode;

	private String summary;
	
	private String accountNumber;
	
	private String date;
}
