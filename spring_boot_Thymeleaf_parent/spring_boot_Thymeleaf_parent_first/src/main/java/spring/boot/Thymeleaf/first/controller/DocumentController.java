package spring.boot.Thymeleaf.first.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.boot.Thymeleaf.first.pojo.Message;
import spring.boot.Thymeleaf.first.pojo.User;

@Controller
@RequestMapping("/document/")
public class DocumentController {
	
	
	

	@RequestMapping("text")
	public ModelAndView text() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/document/text");

		mv.addObject("testTrue", true);

		mv.addObject("testfalse", false);

		mv.addObject("testNull", null);

		mv.addObject("pageType", "thymeleaf");

		mv.addObject("testWith", 100);

		mv.addObject("testGt", 100);

		Message msg = new Message();
		msg.setId(123);
		msg.setSummary(null);

		mv.addObject("msg", msg);

		return mv;

	}

	@RequestMapping("attrVal")
	public ModelAndView attrVal() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/document/attrVal");

		Message msg = new Message();
		msg.setId(123);
		msg.setSummary("summary");
		msg.setCreated(new Date());

		mv.addObject("msg", msg);

		return mv;
	}

	@RequestMapping("session")
	public ModelAndView session(
			HttpSession session) {

		Message msg = new Message();
		msg.setId(1);
		msg.setCreated(new Date());
		msg.setSummary("inputSummary");
		msg.setIsTrue(Boolean.TRUE);

		session.setAttribute("message", msg);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/document/session");

		return mv;
	}

	@RequestMapping(value = "/linkUrl", method = RequestMethod.GET)
	public ModelAndView linkUrl() {

		ModelAndView mv = new ModelAndView();

		// mv.addObject("url","/document/session");
		mv.addObject("url", "~/document/session");
		mv.addObject("visitUrl", "/visit/");

		mv.setViewName("/document/linkUrl");

		return mv;

	}

	
	@RequestMapping("aggregates")
	public ModelAndView aggregates(){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/document/aggregates");
		
		List<User> userList = new ArrayList<User>();
		
		for(int i = 0;i<=5;i++){
			
			User user = new User();
			user.setId(i);
			user.setUsrName("name"+i);
			
			List<Message> msgList = new ArrayList<Message>();
			
			for(int j = 5;j>=0;j--){
				
				Message msg  = new Message();
				msg.setId(j);
				msg.setAmount(j);
				msg.setPrice(1.1);
				
				msgList.add(msg);
			}
			
			user.setMessageList(msgList);
			
			userList.add(user);
			
		}
		
		
		
		mv.addObject("userList", userList);
		
		return mv;
		
	}
	
}
