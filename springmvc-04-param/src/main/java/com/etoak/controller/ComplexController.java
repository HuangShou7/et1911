package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.bean.Student;

/**
 * 测试java bean 接收参数
 * 测试数组
 * 测试List
 * 测试Map
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/complex")
public class ComplexController {
	/**
	 * 第三种request域传值
	 * @param student
	 * @param model
	 * @return
	 */
	//Get 请求 @RequestMapping / @GetMapping 4.3
	@GetMapping("/bean")
	public String bean(Student student,Model model) {
		System.out.println(student);
		model.addAttribute("result2","使用Model传值");
		//请求转发到/simple/simple
		return "forward:/simple/simple?id=321";
	}
	
}
