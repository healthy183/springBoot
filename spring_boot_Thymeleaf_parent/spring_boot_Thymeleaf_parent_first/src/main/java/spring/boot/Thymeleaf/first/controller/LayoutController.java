package spring.boot.Thymeleaf.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/layout/")
public class LayoutController {

	@RequestMapping("index")
	public ModelAndView index(){
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/layout/index");
		
		return mv;
	}
}
