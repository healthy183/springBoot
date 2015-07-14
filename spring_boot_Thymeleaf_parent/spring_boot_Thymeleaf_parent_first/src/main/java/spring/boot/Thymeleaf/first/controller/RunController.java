package spring.boot.Thymeleaf.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.boot.Thymeleaf.first.pojo.User;

@Controller
@RequestMapping("/run")
public class RunController {

	
	@RequestMapping(value="/regreeting/{usrName}",method=RequestMethod.GET)
	public ModelAndView regreeting(@PathVariable String usrName){
		
		ModelAndView mv = new ModelAndView("regreeting");
		
		mv.addObject("name",usrName);
		
		User user = new User();
		user.setId(12);
		user.setUsrName("Healthy");
		
		mv.addObject("user",user);
		
		return mv;
	}
	
	@RequestMapping(value="/testURL",method=RequestMethod.GET)
	public ModelAndView testSOAPUI(String testArg,String usrName) {
	
		ModelAndView mv = new ModelAndView("testURL");
		mv.addObject("testArg", testArg);
		mv.addObject("usrName", usrName);
		
		return mv;
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
	
		ModelAndView mv = new ModelAndView("saveUser");
		String name = user.getUsrName();
		mv.addObject("name",name);
		
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/testSOAPUI",method=RequestMethod.GET)
	public ModelAndView testSOAPUI(String testArg, Model model) {

		ModelAndView mv = new ModelAndView("testSOAPUI");

		mv.addObject("arg", testArg);

		return mv;
	}
	
	@RequestMapping(value="/testSOAPUI",method=RequestMethod.POST)
	public ModelAndView testSOAPUIPost(String testArg, Model model) {

		ModelAndView mv = new ModelAndView("testSOAPUI");

		mv.addObject("arg", testArg);

		return mv;
	}
	
	
}
