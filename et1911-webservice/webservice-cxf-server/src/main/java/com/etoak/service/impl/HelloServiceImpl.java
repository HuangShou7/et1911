package com.etoak.service.impl;

import com.etoak.service.HelloService;

import javax.jws.WebService;

@WebService(serviceName = "HelloServiceWS",portName = "HelloServiceWSPort")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("服务端被调用");
        return "Hello " + name;
    }
}
