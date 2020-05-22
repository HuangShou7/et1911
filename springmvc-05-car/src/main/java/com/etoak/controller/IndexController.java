package com.etoak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;

@Controller
public class IndexController {
	List<User> userList = new ArrayList<User>();
	int num = 0;
	@PostMapping("/addUser")
	public String add( User user) {
		num = num + 1;
		user.setId(num);
		System.out.println(user);
		userList.add(user);
		System.out.println(userList);
		return "index";
	}
	@GetMapping("/queryAll")
	@ResponseBody
	public List list() {
		System.out.println(userList);
		return userList;
	}
	
	
	//---------------------
	@RequestMapping("/add")
	public String add(String name) {
		//System.out.println(name);
		return "forward:/index";
	}
	@RequestMapping("/test")
	@ResponseBody
	public String test(@RequestBody Map<String,String> map) {
		System.out.println(map);
		return "SUCCESS";
	}
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		//向request域传值
		request.setAttribute("user", new User(1,"requestUser","",20));
		//向session域传值
		request.getSession().setAttribute("sessionUser", new User(2,"sessionUser","",21));
		
		//
		List<User> userList = new ArrayList<>();
		request.setAttribute("userList", userList);
		userList.add(new User(3,"张三","",28));
		userList.add(new User(4,"李四","",39));
		// webapp/templates/index.html
		return "index";
	}
	
	
	
}
