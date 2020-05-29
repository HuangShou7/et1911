package com.etoak.service.com.etoak;

import com.etoak.service.HelloService ;
import com.etoak.service.impl.HelloServiceImpl ;
import org.apache.cxf.endpoint.Server ;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean ;

public class CxfServer {
    public static void main(String[] args) {
        //创建JaxWSServerFactory
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        //设置wsdl地址
        factory.setAddress("http://localhost:8000/hello");
        //设置发布服务接口
        factory.setServiceClass(HelloService.class);
        //设置服务实现
        factory.setServiceBean(new HelloServiceImpl());
        //创建服务
        Server server = factory.create();
        server.start();
        System.out.println("Server start...");
    }
}
