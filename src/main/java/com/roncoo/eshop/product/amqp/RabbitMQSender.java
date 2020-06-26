package com.roncoo.eshop.product.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbittemplate;

	public void send(String operationType, String message) {
		String queue = "";

		if (null != operationType && !"".equals(operationType)) {
			if (operationType.equals("data")) {
				queue = RabbitQueue.DATA_CHANGE_QUEUE;
			} else if (operationType.equals("dim")) {
				queue = RabbitQueue.DIM_DATA_CHANGE_QUEUE;
			} else if (operationType.equals("fresh")) {
				queue = RabbitQueue.FRESH_DATA_CHANGE_QUEUE;
			} else if (operationType.equals("priority")) {
				queue = RabbitQueue.PRIORITY_DATA_CHANGE_QUEUE;
			}
		} else {
			queue = RabbitQueue.DATA_CHANGE_QUEUE;
		}
		rabbittemplate.convertAndSend(queue, message);
	}
}
