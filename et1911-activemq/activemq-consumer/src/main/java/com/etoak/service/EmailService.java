package com.etoak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.etoak.bean.Email;

@Service
public class EmailService {
	
	//简单邮件
	@Autowired
	SimpleMailMessage mailMessage;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	ThreadPoolTaskExecutor executor;
	
	public void sendEmail(Email email) {
		//使用Simple 封装邮件
		mailMessage.setTo(email.getReceiver());
		mailMessage.setSubject(email.getSubject());
		mailMessage.setText(email.getContent());
		
		
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("开始发邮件");
				mailSender.send(mailMessage);
				System.out.println("邮件发送结束");
			}
		});
	}
	
	
	
}
