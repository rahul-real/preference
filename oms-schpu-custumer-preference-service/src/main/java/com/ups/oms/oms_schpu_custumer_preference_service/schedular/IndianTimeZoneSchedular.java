/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.schedular;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  14-Sep-2024 2024 2:38:48 pm
 */
@EnableScheduling
@Component
@Slf4j
public class IndianTimeZoneSchedular {
	
	@Scheduled( cron = "0 49 14 * * ?")
	public void indianSchedular() {
		
		log.info("indianSchedular Job has started at {}",LocalDateTime.now());
		
	}

}
