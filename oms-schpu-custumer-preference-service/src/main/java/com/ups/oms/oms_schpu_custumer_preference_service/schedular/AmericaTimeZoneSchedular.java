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
   @since  14-Sep-2024 2024 2:36:18 pm
 */
@EnableScheduling
@Component
@Slf4j
public class AmericaTimeZoneSchedular {
	
	@Scheduled(cron = "0 19 5 * * ?", zone = "America/New_York")
	public void americaSchedular() {
		
		log.info("americaSchedular Job has started at {}",LocalDateTime.now());
		
	}

}
