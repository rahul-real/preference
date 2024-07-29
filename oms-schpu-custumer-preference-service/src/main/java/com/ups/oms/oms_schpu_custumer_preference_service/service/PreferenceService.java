/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ups.oms.oms_schpu_custumer_preference_service.dto.PreferenceRequest;
import com.ups.oms.oms_schpu_custumer_preference_service.dto.PreferenceResponse;
import com.ups.oms.oms_schpu_custumer_preference_service.dto.RegistrationData;
import com.ups.oms.oms_schpu_custumer_preference_service.repository.CustomerPreferenceRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  28-Jul-2024 2024 7:33:34 pm
 */
@Component
@Slf4j
public class PreferenceService {
	
	@Autowired
	CustomerPreferenceRepository repository;

	/**
	 * @param applicationTransactionNumber
	 * @param preferenceRequest
	 * @return
	 */
	public PreferenceResponse getRegistraionData(String applicationTransactionNumber,
			PreferenceRequest preferenceRequest) {
		PreferenceResponse response = new PreferenceResponse();
		List<RegistrationData> registrationData = new LinkedList<RegistrationData>();
		String parId = String.join(",", preferenceRequest.getParId());
		log.info("ParID {}",parId);
		registrationData = repository.getRegistrationData(applicationTransactionNumber,parId);
		log.info("Registration Data {}",registrationData);
		response.setRegistrationData(registrationData);
		return response;
	}

}
