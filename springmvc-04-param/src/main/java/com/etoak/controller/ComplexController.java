package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	/**
	 * 第四种向request域传值的方式
	 * @param hobby
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/array")
	public String array(String[] hobby,ModelMap modelMap) {
		for(String hobbyStr : hobby) {
			System.out.println("hobby = " + hobbyStr);
		}
		modelMap.addAttribute("result","使用ModelMap传参");
		return "param";
	}
	/**
	 * 第五种接收参数的方法:List
	 * 第五种Request域传值的方式:
	 * @param student
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/list")
	public String array(Student student,Map<String,Object> map) {
		List<String> hobbyList = student.getHobbyList();
		if(!CollectionUtils.isEmpty(hobbyList)) {
			hobbyList.forEach(x -> System.out.println(x));
		}
		map.put("result","使用Map传参");
		return "param";
	}
	/**
	 * 第六种接收参数的方式:使用map
	 * @param student
	 * @return
	 */
	@PostMapping(value="/map",produces= {"text/plain"})
	@ResponseBody //可以返回json,xml,纯文本
	public String map(Student student) {
		System.out.println(student.getStuMap());
		return "success";
	}
	
	
}
