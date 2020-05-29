package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloConsumer {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Queue helloQueue = session.createQueue("hello2");
		MessageConsumer consumer = session.createConsumer(helloQueue);
		TextMessage text = (TextMessage) consumer.receive();
		System.out.println(text.getText().toString());
		consumer.close();
		session.close();
		connection.close();

	}

}
