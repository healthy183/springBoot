package spring.boot.first.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.first.mvc.jsonObject.Address;
import spring.boot.first.mvc.jsonObject.User;

@RestController
@RequestMapping("/json")
public class JsonController {

	@RequestMapping(value="getUser")
	public User getUser(){
		
		User user = new User();
		user.setName("healthy");
		user.setPassword("123");
		user.setAge(12);
		
		user.setAddress(new Address("广东","广州"));
		
		String[] favourite = {"apple","banana"};
		
		user.setFavourite(favourite);
		
		return user;
		
	}
	
	
}
