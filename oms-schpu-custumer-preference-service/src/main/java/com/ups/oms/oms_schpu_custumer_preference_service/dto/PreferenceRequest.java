/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import com.ups.oms.oms_schpu_custumer_preference_service.annotation.DataFormat;

import lombok.Data;

/**
 * @author rahul
   @since  28-Jul-2024 2024 7:16:30 pm
 */
@Data
public class PreferenceRequest {
	
	//@NotBlank(message = "ParId should not be blank")
	private List<@Pattern(regexp = "^[a-zA-Z0-9]{1,10}$") String> parId;
	
	@DataFormat(pattern = "yyy-MM-dd",message = "Date Format should be yyyy-MM-dd")
	private String date;
	
	@Max(value = 10,message = "RequestComents can't be more than 10")
	private String requestComents;
	
	
	

}
