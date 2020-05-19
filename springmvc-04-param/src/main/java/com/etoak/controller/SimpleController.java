package com.etoak.controller;
/**
 * 使用HttpServlerRequest
 * 使用基本数据类型 , String
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/simple")
public class SimpleController {
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/servlet")
	public String servlet(HttpServletRequest request) {
		//接收前端参数
		String name = request.getParameter("name");
		if (StringUtils.isEmpty(name)) {
			name = "world";
		}
		//返回,向request域传值
		request.setAttribute("result", "Hello ~" + name);
		return "param";
	}
	@RequestMapping(value="/simple", method = {RequestMethod.GET})
	public ModelAndView simple(@RequestParam(required = false,defaultValue = "1") int id,
			String name) {
		System.out.println("id param =" + id);
		System.out.println("name param =" + name);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result","ModelAndView传值");
		mv.setViewName("param");
		return mv;
		
	}
	
	
}
