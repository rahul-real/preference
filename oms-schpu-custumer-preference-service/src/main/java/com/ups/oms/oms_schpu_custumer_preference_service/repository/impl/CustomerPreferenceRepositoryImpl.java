/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ups.oms.oms_schpu_custumer_preference_service.config.StoredProcedures;
import com.ups.oms.oms_schpu_custumer_preference_service.dto.RegistrationData;
import com.ups.oms.oms_schpu_custumer_preference_service.dto.RegistrationRequest;
import com.ups.oms.oms_schpu_custumer_preference_service.repository.CustomerPreferenceRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  27-Jul-2024 2024 6:30:10 pm
 */
@Slf4j
@Repository
@Transactional
public class CustomerPreferenceRepositoryImpl  implements CustomerPreferenceRepository{
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Autowired
	StoredProcedures storedProcedures;
	
	

	@Override
	public void insertRegistrationData(String applicationSystemNumber,Byte success,RegistrationRequest registrationRequest) {
		EntityManager entityManager = null;
		StoredProcedureQuery storedProcedureQuery = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			storedProcedureQuery = entityManager.createStoredProcedureQuery(storedProcedures.getInsertRegistrationData());
			storedProcedureQuery.registerStoredProcedureParameter("ApplicationSystemNumber", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("RegistrationIdentifier", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("RegistrationStatusCode", Byte.class, ParameterMode.IN)
				.registerStoredProcedureParameter("UserComents", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("AccountNumber", String.class, ParameterMode.IN)
				.setParameter("ApplicationSystemNumber", applicationSystemNumber)
				.setParameter("RegistrationIdentifier", registrationRequest.getParId())
				.setParameter("RegistrationStatusCode", success)
				.setParameter("UserComents", registrationRequest.getSummary())
				.setParameter("AccountNumber", registrationRequest.getAccountNumber());
			storedProcedureQuery.execute();
			
		} catch (Exception e) {
			log.info("ApplicationSystemNumber {} Exception {}",applicationSystemNumber,e.getMessage());
		}
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationData> getRegistrationData(String applicationTransactionNumber, String parId) {
		EntityManager entityManager = null;
		StoredProcedureQuery storedProcedureQuery = null;
		List<RegistrationData> registrationData = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			storedProcedureQuery = entityManager.createStoredProcedureQuery(storedProcedures.getGetRegistrationData());
			storedProcedureQuery.registerStoredProcedureParameter("ParId", String.class, ParameterMode.IN)
			.setParameter("ParId", parId);
			storedProcedureQuery.execute();
			List<Object[]> object = storedProcedureQuery.getResultList();
			if(object != null && !object.isEmpty()) {
				log.info("Stored Procedure Result: {}", object);
				registrationData = object.stream().map(RegistrationData::new).collect(Collectors.toList());
				
			}
		}catch (Exception e) {
			log.info("ApplicationSystemNumber {} Failed due to {}",e.getMessage());
			throw e;
		}
		return registrationData;
	}

}
