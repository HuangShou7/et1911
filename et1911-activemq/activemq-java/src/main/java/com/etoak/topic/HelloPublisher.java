package com.etoak.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloPublisher {

	public static void main(String[] args) throws JMSException {
		//1.创建ConnectionFactory
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		//2.Connection start()
		Connection connection = factory.createConnection();
		connection.start();
		//3.Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//4.队列
		Topic topic = session.createTopic("topic");
		//5.producder
		MessageProducer producer = session.createProducer(topic);
		//6.Message
		MapMessage msg = session.createMapMessage();
		msg.setString("name", "topic msg");
		msg.setInt("id", 1);
		
		producer.send(msg);
		
		producer.close();
		session.close();
		connection.close();
	}

}
