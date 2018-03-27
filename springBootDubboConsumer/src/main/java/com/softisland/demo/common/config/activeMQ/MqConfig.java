package com.softisland.demo.common.config.activeMQ;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import com.jfinal.kit.PropKit;

@Configuration
public class MqConfig {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("mvp.queue");
	}

	@Bean
	public Topic topic() {
		return new ActiveMQTopic("mvp.topic");
	}
	
	@Bean("pornjamQueue")
	public Queue pornjamQueue(){
		return new ActiveMQQueue("pornjam.queue");
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(PropKit.get("activemq_username"), PropKit.get("activemq_pwd"), PropKit.get("activemq_host"));
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerPubSub(ActiveMQConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(connectionFactory);
		return bean;
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setConnectionFactory(connectionFactory);
		return bean;
	}

	@Bean
	public JmsMessagingTemplate jmsMessagingTemplate(ActiveMQConnectionFactory connectionFactory) {
		return new JmsMessagingTemplate(connectionFactory);
	}
}
