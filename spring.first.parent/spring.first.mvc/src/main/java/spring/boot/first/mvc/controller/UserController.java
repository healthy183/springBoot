package spring.boot.first.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring.boot.first.dao.dbOrder.vo.User;




@RestController
@RequestMapping("/user")
public class UserController {

	@Value("${application.message}")
	private String message;
	
	//http://localhost:9090/user/jsonUser
	@RequestMapping("/jsonUser")
	public User jsonUser(){
		
		User user = new User();
		user.setId(123L);
		user.setName("Healthy梁健康");
		
		return user;
	}
	
	//http://localhost:9090/user/showView
	@RequestMapping(value="/showView",method=RequestMethod.GET)
	public ModelAndView showView(){
		
		ModelAndView m = new ModelAndView();
		m.setViewName("user/showView");
		m.addObject("testObj","test successfully!");
		m.addObject("message",message);
		return m;
	}
	
	
		
}
