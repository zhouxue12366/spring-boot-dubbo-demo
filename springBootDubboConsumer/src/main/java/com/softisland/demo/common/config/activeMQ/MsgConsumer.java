package com.softisland.demo.common.config.activeMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.softisland.api.business.demo.DemoApiService;

@Component
public class MsgConsumer{

	@Reference
	private DemoApiService demoService;
	
//	@JmsListener(destination = "mvp.topic", containerFactory = "jmsListenerContainerPubSub")
//	public void receiveTopic(String text) {
//		List<Record> records = demoService.sayHello(text);
//		System.out.println("消费者Topic Consumer1查询数据库的条数为:" + records.size());
//	}
//
//	@JmsListener(destination = "mvp.topic", containerFactory = "jmsListenerContainerPubSub")
//	public void receiveTopic2(String text) {
//		System.out.println("消费者Topic Consumer2:" + text);
//	}
//
//	@JmsListener(destination = "mvp.queue", containerFactory = "jmsListenerContainerQueue")
//	public void reviceQueue(String text) {
//		System.out.println("消费者Queue Consumer:" + text);
//	}
	
//	@JmsListener(destination = "pornjam.queue", containerFactory = "jmsListenerContainerQueue")
//	public void reviceQueue2(String text) {
//		System.out.println("消费者Queue Consumer2:" + text);
//	}
	
	@JmsListener(destination = "test-activemq-queue", containerFactory = "jmsListenerContainerQueue")
	public void reviceQueue3(String text) {
		System.out.println("消费者Queue Consumer3:" + text);
	}

}
