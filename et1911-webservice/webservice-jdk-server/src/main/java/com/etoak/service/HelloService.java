package com.etoak.service;

import javax.jws.WebService;

/**
 * 表示这是一个web service 接口
 * 接口和实现类都必须加注解@WebService
 */
@WebService
public interface HelloService {
    String sayHello(String name);
}
