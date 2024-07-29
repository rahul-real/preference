/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ups.oms.oms_schpu_custumer_preference_service.dto.RegistrationData;
import com.ups.oms.oms_schpu_custumer_preference_service.dto.RegistrationRequest;

/**
 * @author rahul
   @since  27-Jul-2024 2024 6:29:11 pm
 */
@Component
public interface CustomerPreferenceRepository {

	/**
	 * @param applicationSystemNumber 
	 * @param success 
	 * @param registrationRequest
	 */
	void insertRegistrationData(String applicationSystemNumber, Byte success, RegistrationRequest registrationRequest);

	/**
	 * @param applicationTransactionNumber
	 * @param parId
	 * @return
	 */
	List<RegistrationData> getRegistrationData(String applicationTransactionNumber, String parId);

}
