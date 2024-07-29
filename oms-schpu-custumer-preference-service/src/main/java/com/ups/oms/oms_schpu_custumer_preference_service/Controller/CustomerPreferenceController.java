/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ups.oms.oms_schpu_custumer_preference_service.dto.PreferenceRequest;
import com.ups.oms.oms_schpu_custumer_preference_service.dto.PreferenceResponse;
import com.ups.oms.oms_schpu_custumer_preference_service.service.PreferenceService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  27-Jul-2024 2024 7:28:25 pm
 */
@Slf4j
@RestController
@RequestMapping("/schpu")
public class CustomerPreferenceController {
	
	@Autowired
	PreferenceService preferenceService;
	
	@PostMapping("/registrationData")
	public ResponseEntity<PreferenceResponse> getRegistrationData(@Valid @RequestBody PreferenceRequest preferenceRequest,HttpServletRequest request){
		
		String applicationTransactionNumber = request.getHeader("ApplicationTransactionNumber");
		
		log.info("Registraion Request {}",preferenceRequest);
		
		PreferenceResponse response = preferenceService.getRegistraionData(applicationTransactionNumber,preferenceRequest) ;
		
		return new ResponseEntity<PreferenceResponse>(response,HttpStatus.OK);
	}

}
