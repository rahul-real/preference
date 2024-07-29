/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rahul
   @since  28-Jul-2024 2024 7:29:11 pm
 */
@Data
@NoArgsConstructor
public class RegistrationData {
	
	private String accountNumber;
	
	private String parId;
	
	private Byte registrationStatusCode;
	
	public RegistrationData(Object...objects) {
		
		this.accountNumber = String.valueOf(objects[0]);
		this.parId = String.valueOf(objects[1]);
		this.registrationStatusCode = Byte.valueOf((byte) objects[2]);
		
	}

}
