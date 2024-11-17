/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  28-Jul-2024 2024 7:29:11 pm
 */
@Data
@NoArgsConstructor
@Slf4j
public class RegistrationData {
	
	private String accountNumber;
	
	private String parId;
	
	private Byte registrationStatusCode;
	
	public RegistrationData(Object[] objects) {
	    try {
	        this.accountNumber = String.valueOf(objects[0]);
	        this.parId = String.valueOf(objects[1]);
	        this.registrationStatusCode = Byte.valueOf(String.valueOf(objects[2]));
	    } catch (ArrayIndexOutOfBoundsException e) {
	        log.error("ArrayIndexOutOfBoundsException: Expected 3 elements but got {}", objects.length, e);
	        throw e;
	    } catch (Exception e) {
	        log.error("Error initializing RegistrationData: {}", e.getMessage(), e);
	        throw e;
	    }
	}

}
