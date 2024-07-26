/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.config;

import javax.annotation.PostConstruct;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.activemq.ActiveMQComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author rahul
   @since  25-Jul-2024 2024 7:37:45 pm
 */
@Component
public class MQBeanConfiguration {
	
	@Autowired
	CamelContext camelContext;
	
	@Autowired
	QueueConfig queues;
	
	@PostConstruct
	public void addCamelContext() {
		PooledConnectionFactory pooledConnection = activeMqConnectionFactorym();
		ActiveMQComponent activeMQComponent = new ActiveMQComponent();
		activeMQComponent.setConnectionFactory(pooledConnection);
		camelContext.addComponent(queues.getComponentName(), activeMQComponent);
		
	}

	/**
	 * @return
	 */
	private PooledConnectionFactory activeMqConnectionFactorym() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(queues.getUsername(),queues.getPassword(),queues.getBrokerUrl());
		PooledConnectionFactory connection = new PooledConnectionFactory();
		connection.setConnectionFactory(activeMQConnectionFactory);
		connection.setMaxConnections(queues.getMaxConnections());
		connection.setMaximumActiveSessionPerConnection(queues.getMaxActive());
		return connection;
	}
	
	

}
