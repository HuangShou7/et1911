package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;
/**
 * @Configuration==<beans>标签
 * 表示spring ioc容器
 * */
@Configuration 
public class UserConfig {
	//注册spring bean 返回类型:==class 方法名:==id,可修改
	@Bean("userService")
	public UserService userService() {
		return new UserService();
	}
	@Bean
	public UserAction userAction(@Qualifier("userService")UserService userService) {
		UserAction userAction = new UserAction();
		//userAction.setUserService(this.userService);
		
		//配合@Qualifier使用,代表@Autowired,相当于ref
		userAction.setUserService(userService);
		return userAction;
	}
}
